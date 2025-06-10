package ZCWDelta.ZipTube.services;

//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.WebClient;
//import org.springframework.http.MediaType;
//import java.util.Map;
//import java.util.List;
//
//@Service
//public class ChatService {
//
//    @Value("${openai.api.key}")
//    private String apiKey;
//
//    private WebClient webClient;
//
//    private void init(){
//        this.webClient = WebClient.builder()
//                .baseUrl("https://api.openai.com/v1")
//                .defaultHeader("Authorization", "Bearer " + apiKey)
//                .build();
//    }
//
//    public String askChatGPT(String message) {
//        Map<String, Object> requestBody = Map.of(
//                "model", "gpt-3.5-turbo",
//                "messages", List.of(Map.of("role", "user", "content", message)),
//                "temperature", 0.7
//        );
//
//        Map response = webClient.post()
//                .uri("/chat/completions")
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue(requestBody)
//                .retrieve()
//                .bodyToMono(Map.class)
//                .block();
//
//        try {
//            List<Map<String, Object>> choices = (List<Map<String, Object>>) response.get("choices");
//            Map<String, Object> messageMap = (Map<String, Object>) choices.get(0).get("message");
//            return (String) messageMap.get("content");
//        } catch (Exception e) {
//            return "Failed to parse response from OpenAI.";
//        }
//    }
//}

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

@Service
public class ChatService {
    @Value("${openai.api.key}")
    private String openAiApiKey; // store securely in env vars or config

    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<String> askForVideoLinks(String prompt) {
        try {
            // Build JSON body safely
            Map<String, Object> message1 = Map.of(
                    "role", "system",
                    "content", "You are an assistant that provides short, educational bullet points. Each bullet point must contain a fact and end with a useful clickable link in this format: Fact – [Link Text](https://example.com)"
            );
            Map<String, Object> message2 = Map.of(
                    "role", "user",
                    "content", "Give me 5 bullet points about: " + prompt
            );

            Map<String, Object> requestBody = Map.of(
                    "model", "gpt-4o",
                    "messages", List.of(message1, message2),
                    "temperature", 0.7
            );

            String requestJson = objectMapper.writeValueAsString(requestBody);

            // Create HTTP request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.openai.com/v1/chat/completions"))
                    .header("Authorization", "Bearer " + openAiApiKey)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestJson))
                    .build();

            // Send request
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();
            System.out.println("🧠 OpenAI raw response:\n" + body);

            // Extract GPT response content
            String content = extractContentFromOpenAIResponse(body);
            return Arrays.asList(content.split("\n")).stream()
                    .filter(line -> !line.trim().isEmpty())
                    .toList();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return List.of("⚠️ Error: Could not fetch educational suggestions.");
        }
    }

    private String extractContentFromOpenAIResponse(String json) {
        try {
            Map<?, ?> root = objectMapper.readValue(json, Map.class);
            List<Map<String, Object>> choices = (List<Map<String, Object>>) root.get("choices");
            Map<String, Object> message = (Map<String, Object>) choices.get(0).get("message");
            return (String) message.get("content");
        } catch (Exception e) {
            e.printStackTrace();
            return "⚠️ Error parsing GPT response.";
        }
    }
}

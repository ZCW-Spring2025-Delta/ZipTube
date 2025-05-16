package ZCWDelta.ZipTube.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.MediaType;
import java.util.Map;
import java.util.List;

@Service
public class ChatService {

    @Value("${openai.api.key}")
    private String apiKey;

    private WebClient webClient;

    private void init(){
        this.webClient = WebClient.builder()
                .baseUrl("https://api.openai.com/v1")
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .build();
    }

    public String askChatGPT(String message) {
        Map<String, Object> requestBody = Map.of(
                "model", "gpt-3.5-turbo",
                "messages", List.of(Map.of("role", "user", "content", message)),
                "temperature", 0.7
        );

        Map response = webClient.post()
                .uri("/chat/completions")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        try {
            List<Map<String, Object>> choices = (List<Map<String, Object>>) response.get("choices");
            Map<String, Object> messageMap = (Map<String, Object>) choices.get(0).get("message");
            return (String) messageMap.get("content");
        } catch (Exception e) {
            return "Failed to parse response from OpenAI.";
        }
    }
}
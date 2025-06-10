package ZCWDelta.ZipTube.controllers;

import ZCWDelta.ZipTube.ChatRequestDTO;
import ZCWDelta.ZipTube.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "*") // Allow from frontend (adjust as needed)
public class ChatController {

    @Autowired
    private ChatService chatService;

//    @PostMapping
//    public String chat(@RequestBody ChatRequestDTO request) {
//        System.out.println("Received message: " + request.getMessage());
//        return chatService.askChatGPT(request.getMessage());
//    }
    @PostMapping("/suggestions")
    public ResponseEntity<List<String>> getSuggestions(@RequestBody Map<String, String> payload) {
        String prompt = payload.get("prompt");
        return ResponseEntity.ok(chatService.askForVideoLinks(prompt));
    }
}

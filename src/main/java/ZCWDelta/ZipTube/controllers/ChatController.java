package ZCWDelta.ZipTube.controllers;

import ZCWDelta.ZipTube.ChatRequestDTO;
import ZCWDelta.ZipTube.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "*") // Allow from frontend (adjust as needed)
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping
    public String chat(@RequestBody ChatRequestDTO request) {
        System.out.println("Received message: " + request.getMessage());
        return chatService.askChatGPT(request.getMessage());
    }
}

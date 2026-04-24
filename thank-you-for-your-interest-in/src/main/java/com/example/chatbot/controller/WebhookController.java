package com.example.chatbot.controller;

import com.example.chatbot.dto.MessageRequest;
import com.example.chatbot.dto.MessageResponse;
import com.example.chatbot.service.ChatbotService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhook")
public class WebhookController {

    private static final Logger logger = LoggerFactory.getLogger(WebhookController.class);

    private final ChatbotService chatbotService;

    public WebhookController(ChatbotService chatbotService) {
        this.chatbotService = chatbotService;
    }

    @PostMapping
    public ResponseEntity<MessageResponse> receiveMessage(@Valid @RequestBody MessageRequest request) {
        logger.info("Incoming message received: {}", request.getMessage());

        String reply = chatbotService.generateReply(request.getMessage());
        return ResponseEntity.ok(new MessageResponse(reply));
    }
}

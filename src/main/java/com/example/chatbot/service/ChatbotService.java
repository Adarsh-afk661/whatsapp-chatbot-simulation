package com.example.chatbot.service;

import org.springframework.stereotype.Service;

@Service
public class ChatbotService {

    public String generateReply(String message) {
        if (message == null || message.trim().isEmpty()) {
            return "Please send a valid message";
        }

        String normalizedMessage = message.trim().toLowerCase();

        return switch (normalizedMessage) {
            case "hi" -> "Hello";
            case "bye" -> "Goodbye";
            default -> "I don't understand";
        };
    }
}

package com.example.chatbot.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChatbotServiceTest {

    private final ChatbotService chatbotService = new ChatbotService();

    @Test
    void shouldReplyHelloForHi() {
        assertEquals("Hello", chatbotService.generateReply("Hi"));
    }

    @Test
    void shouldReplyGoodbyeForBye() {
        assertEquals("Goodbye", chatbotService.generateReply("Bye"));
    }

    @Test
    void shouldReplyDefaultForUnknownMessage() {
        assertEquals("I don't understand", chatbotService.generateReply("How are you?"));
    }

    @Test
    void shouldIgnoreCaseAndSpaces() {
        assertEquals("Hello", chatbotService.generateReply("  hi  "));
    }
}

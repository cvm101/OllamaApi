package com.example.olamaAi.controller;

import com.example.olamaAi.service.OllamaService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api") // Base path
public class ChatController {

    private final OllamaService ollamaService;

    public ChatController(OllamaService ollamaService) {
        this.ollamaService = ollamaService;
    }

    @PostMapping("/chat") // Full path will be POST /api/chat
    public ResponseEntity<ChatResponse> chat(@RequestBody ChatRequest request) {
        String response = ollamaService.generateResponse(request.getPrompt());
        return ResponseEntity.ok(new ChatResponse(response));
    }

    @Data
    static class ChatRequest {
        private String prompt;
    }

    @Data
    @AllArgsConstructor
    static class ChatResponse {
        private String response;
    }
}
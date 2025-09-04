package com.example.olamaAi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class OllamaService {

    private final String OLLAMA_API_URL = "http://localhost:11434/api/generate";
    private  final RestTemplate restTemplate;

    public OllamaService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public String generateResponse(String prompt){
        Map<String , Object> request = new HashMap<>();
        request.put("model", "deepseek-r1:latest");
        request.put("prompt", prompt);
        request.put("stream", false);

        ResponseEntity<String> response = restTemplate.postForEntity(
                OLLAMA_API_URL,
                request,
                String.class
        );

        try{
            JsonNode jsonNode = new ObjectMapper().readTree(response.getBody());
            return jsonNode.get("response").asText();
        }catch (JsonProcessingException e){
            throw new RuntimeException("Faled to respond", e);
        }


    }


}

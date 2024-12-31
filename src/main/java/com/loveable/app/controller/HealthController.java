package com.loveable.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthController {
    @GetMapping(value = { "/", "/health"})
    public ResponseEntity<Map<String, String>> getHealth() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "alive");
        return ResponseEntity.ok(response);
    }
}
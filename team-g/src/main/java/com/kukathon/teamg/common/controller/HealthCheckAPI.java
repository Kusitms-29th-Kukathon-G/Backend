package com.kukathon.teamg.common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckAPI {
    @GetMapping("/api/health")
    public String healthCheck() {
        return "큐커톤G조 성공!";
    }
}
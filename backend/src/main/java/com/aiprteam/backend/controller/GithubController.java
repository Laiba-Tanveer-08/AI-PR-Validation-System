package com.aiprteam.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/github")
public class GithubController {
    @PostMapping("/webhook")
public ResponseEntity<String> webhook(@RequestBody String payload){
        System.out.println("Github sent me something yaaaaayyyyy!!!!!");
        System.out.println(payload);
        return  ResponseEntity.ok("webhook");
    }

}

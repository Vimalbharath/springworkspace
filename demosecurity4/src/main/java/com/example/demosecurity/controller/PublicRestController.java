package com.example.demosecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicRestController {

    @GetMapping("/public")
    public ResponseEntity<String> getPublicData() {
        return ResponseEntity.ok("Public data");
    }
}
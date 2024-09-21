package com.example.demosecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasRole('CAPTAIN')") // Only accessible to users with "CAPTAIN" role
public class CaptainRestController {

    @GetMapping("/captain/data")
    public ResponseEntity<String> getCaptainData() {
        return ResponseEntity.ok("Captain data");
    }
}
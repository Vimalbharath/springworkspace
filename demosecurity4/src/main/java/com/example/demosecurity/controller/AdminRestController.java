package com.example.demosecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasRole('ADMIN')") // Only accessible to users with "ADMIN" role
public class AdminRestController {

    @GetMapping("/admin/settings")
    public ResponseEntity<String> getAdminSettings() {
        return ResponseEntity.ok("Admin settings");
    }
}
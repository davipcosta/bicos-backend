package com.example.demo.bicos.controller.dto;

import com.example.demo.bicos.models.UserRole;

public record RegisterDto(String login, String mail, String password, UserRole role) {
    
}

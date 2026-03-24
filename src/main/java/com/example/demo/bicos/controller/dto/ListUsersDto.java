package com.example.demo.bicos.controller.dto;

import java.util.UUID;

import com.example.demo.bicos.models.User;

public record ListUsersDto(UUID id, String username, String mail) {
    public ListUsersDto(User user){
        this(user.getId(), user.getUsername(), user.getMail());
    }
}

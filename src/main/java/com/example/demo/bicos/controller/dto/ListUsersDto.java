package com.example.demo.bicos.controller.dto;

import java.util.UUID;

import com.example.demo.bicos.models.User;

public record ListUsersDto(UUID id, String login, String mail) {
    public ListUsersDto(User user){
        this(user.getId(), user.getLogin(), user.getMail());
    }
}

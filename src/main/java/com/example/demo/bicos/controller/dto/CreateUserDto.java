package com.example.demo.bicos.controller.dto;

import com.example.demo.bicos.models.User.UserRole;


public record CreateUserDto(String username, String mail, String password, UserRole role ) {
}

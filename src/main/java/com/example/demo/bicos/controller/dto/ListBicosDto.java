package com.example.demo.bicos.controller.dto;

import com.example.demo.bicos.models.Bicos;

public record ListBicosDto(Long id, String name, String description, String city,Long price) {
    public ListBicosDto(Bicos bicos){
        this(bicos.getId(), bicos.getName(), bicos.getDescription(), bicos.getCity(), bicos.getPrice());
    }
}

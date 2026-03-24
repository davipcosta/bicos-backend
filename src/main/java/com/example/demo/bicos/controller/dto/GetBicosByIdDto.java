package com.example.demo.bicos.controller.dto;

import java.time.Instant;

public record GetBicosByIdDto(String id, String name, String description, Long price, Instant created_at, Instant updated_at) {
    
}

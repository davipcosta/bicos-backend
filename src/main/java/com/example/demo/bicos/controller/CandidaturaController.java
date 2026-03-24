package com.example.demo.bicos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bicos.service.CandidaturaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name="Candidatura")
@RequestMapping("/api/candidaturas")
public class CandidaturaController {

    private final CandidaturaService candidaturaService;

    public CandidaturaController(CandidaturaService candidaturaService) {
        this.candidaturaService = candidaturaService;
    }

    @Operation(summary="Canditatar-se em um bico")
    @PostMapping("/{userId}/{bicoId}")
    public ResponseEntity<Void> candidatar(@PathVariable String userId, @PathVariable Long bicoId){
        candidaturaService.candidatar(userId, bicoId);
        return ResponseEntity.ok().build();
    }

    @Operation(summary="Aprovar uma candidatura")
    @PostMapping("/{id}/aprovar/{aprovadorId}")
    public ResponseEntity<Void> aprovar(@PathVariable Long id, @PathVariable String aprovadorId){
        candidaturaService.aprovar(id, aprovadorId);
        return ResponseEntity.ok().build();
    }

    @Operation(summary="Rejeitar uma candidatura")
    @PostMapping("/{id}/rejeitar/{aprovadorId}")
    public ResponseEntity<Void> rejeitar(@PathVariable Long id, @PathVariable String aprovadorId){
        candidaturaService.rejeitar(id, aprovadorId);
        return ResponseEntity.ok().build();
    }

}

package com.example.demo.bicos.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bicos.controller.dto.GetBicosByIdDto;
import com.example.demo.bicos.controller.dto.ListBicosDto;
import com.example.demo.bicos.controller.dto.RegisterBicosDto;
import com.example.demo.bicos.service.BicosService;
import com.example.demo.bicos.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Bicos")
@RestController
@RequestMapping("/api/bicos")
public class BicosController {

    private final BicosService bicosService;
    private final UserService userService;

    public BicosController(BicosService bicosService, UserService userService) {
        this.bicosService = bicosService;
        this.userService = userService;
    }

    @Operation(summary = "Listar bicos")
    @GetMapping
    public ResponseEntity<List<ListBicosDto>> getAllBicos(){
        List<ListBicosDto> users = bicosService.listBicos()
        .stream()
        .map(ListBicosDto::new)
        .collect(Collectors.toList());

    return ResponseEntity.ok(users);
    }

    @PostMapping("/{userId}")
    @Operation(summary="Registrar bicos por ID do usuário")
    public ResponseEntity<Void> registerBicoById(@PathVariable("userId") String userId,
                                     @RequestBody RegisterBicosDto registerBicosDto){
        userService.registerBicos(userId, registerBicosDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    @Operation(summary="Buscar bicos por ID do usuário")
    public ResponseEntity<List<GetBicosByIdDto>> getBicos(@PathVariable("userId") String userId){
        var bicos = userService.getBicosById(userId);
        return ResponseEntity.ok(bicos);
    }
}

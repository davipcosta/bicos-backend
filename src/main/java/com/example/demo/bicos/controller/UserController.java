package com.example.demo.bicos.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bicos.controller.dto.CreateUserDto;
import com.example.demo.bicos.controller.dto.ListUsersDto;
import com.example.demo.bicos.controller.dto.UpdateUserDto;
import com.example.demo.bicos.models.User;
import com.example.demo.bicos.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name="Usuários")
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;

    }

    @Operation(summary = "Listar usuários")
    @GetMapping
    public ResponseEntity<List<ListUsersDto>> getAllUsers(){
        List<ListUsersDto> users = userService.listUsers()
        .stream()
        .map(ListUsersDto::new)
        .collect(Collectors.toList());

    return ResponseEntity.ok(users);
    }

    @Operation(summary = "Buscar usuário por ID")
    @GetMapping("/{userId}")
        public ResponseEntity<User> getUserById(@PathVariable("userId") String userId) {
        var user = userService.getUserById(userId);
       
        return user.map(ResponseEntity::ok)
               .orElseGet(() -> ResponseEntity.notFound().build());
        }

    @PostMapping
    @Operation(summary = "Criar usuário")
    public ResponseEntity<User> createUser(@RequestBody CreateUserDto createUserDto) {
        var userId = userService.createUser(createUserDto);
        
        return ResponseEntity.created(URI.create("/v1/user/" + userId.toString())).build();
    }
    
    @PatchMapping("/{userId}")
    @Operation(summary="Atualizar usuário por ID")
    public ResponseEntity<Void> updateUserById(
        @PathVariable String userId,
        @RequestBody UpdateUserDto updateUserDto) {

    userService.updateUserById(userId, updateUserDto);
    return ResponseEntity.noContent().build();                            
}

    @Operation(summary = "Deletar usuário por ID")
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteById(@PathVariable("userId") String userId){
        userService.deleteById(userId);
        return ResponseEntity.noContent().build();
    }  
    
}

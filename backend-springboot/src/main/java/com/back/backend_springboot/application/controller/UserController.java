package com.back.backend_springboot.application.controller;

import com.back.backend_springboot.domain.model.UserEntity;
import com.back.backend_springboot.domain.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/users")
@SecurityScheme(name = "Bearer Auth",
        description = "Descripción de autenticación JWT",
        scheme = "Bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
@SecurityRequirement(name = "Bearer Auth")
@Tag(name = "User Management", description = "Operaciones CRUD para usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Obtener todos los usuarios", description = "Devuelve una lista de todos los usuarios")
    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @Operation(summary = "Obtener un usuario por ID", description = "Devuelve un usuario basado en su ID")
    @GetMapping("/{id}")
    public UserEntity getUserById(
        @Parameter(description = "ID del usuario a obtener", required = true)
        @PathVariable Long id) {
        return userService.getUserById(id);
    }

    @Operation(summary = "Crear un nuevo usuario", description = "Crea un nuevo usuario")
    @PostMapping
    public UserEntity createUser(
        @Parameter(description = "Usuario a crear. No incluya el ID.", required = true, content = @Content(schema = @Schema(implementation = UserEntity.class)))
        @RequestBody UserEntity user) {
        return userService.saveUser(user);
    }

    @Operation(summary = "Actualizar un usuario", description = "Actualiza un usuario basado en su ID")
    @PutMapping("/{id}")
    public UserEntity updateUser(
        @Parameter(description = "ID del usuario a actualizar", required = true)
        @PathVariable Long id,
        @Parameter(description = "Detalles del usuario a actualizar", required = true, content = @Content(schema = @Schema(implementation = UserEntity.class)))
        @RequestBody UserEntity userDetails) {
        return userService.updateUser(id, userDetails);
    }

    @Operation(summary = "Eliminar un usuario", description = "Elimina un usuario basado en su ID")
    @DeleteMapping("/{id}")
    public void deleteUser(
        @Parameter(description = "ID del usuario a eliminar", required = true)
        @PathVariable Long id) {
        userService.deleteUser(id);
    }
}

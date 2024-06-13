package com.back.backend_springboot.application.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.backend_springboot.application.dto.LoginDto;
import com.back.backend_springboot.config.JwtUtil;
import com.back.backend_springboot.domain.model.UserEntity;
import com.back.backend_springboot.domain.repository.UserRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/auth")
@Tag(name = "Login", description = "Autenticación de inicio de sesión con JWT")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }

    @Operation(
            summary = "Iniciar sesión con tu rol predeterminado",
            description = "Con las credenciales correctas, devuelve un token Bearer para usar en cada solicitud HTTP.",
            tags = {"Login"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuario Autenticado"),
            @ApiResponse(responseCode = "400", description = "Solicitud Incorrecta")
    })
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginDto loginDto) {
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());
        Authentication authentication = this.authenticationManager.authenticate(login);

        if (authentication.isAuthenticated()) {
            String jwt = this.jwtUtil.create(loginDto.getUsername());

            Map<String, String> response = new HashMap<>();
            response.put("token", jwt);

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @Operation(
            summary = "Obtener usuario actual",
            description = "Devuelve los detalles del usuario actualmente autenticado.",
            tags = {"Usuario"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuario encontrado"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    @GetMapping("/actual-usuario")
    public ResponseEntity<UserEntity> obtenerUsuarioActual(Principal principal) {
        Optional<UserEntity> userEntityOptional = userRepository.findByUsername(principal.getName());
        return userEntityOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}

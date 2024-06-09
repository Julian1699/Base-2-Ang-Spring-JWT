package com.back.backend_springboot.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "objeto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Objeto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String descripcion;

    private Double precio;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;
}

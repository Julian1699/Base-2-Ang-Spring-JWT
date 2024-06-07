package com.back.backend_springboot.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20, unique = true)
    private String username;

    @Column(nullable = false, length = 200)
    private String password;

    @Column(length = 50)
    private String email;

    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean locked;

    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean disabled;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<UserRoleEntity> roles;
}


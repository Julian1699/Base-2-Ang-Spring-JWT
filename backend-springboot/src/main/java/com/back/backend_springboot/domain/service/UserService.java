package com.back.backend_springboot.domain.service;

import com.back.backend_springboot.application.exception.ResourceNotFoundException;
import com.back.backend_springboot.domain.model.UserEntity;
import com.back.backend_springboot.domain.model.UserRoleEntity;
import com.back.backend_springboot.domain.repository.UserRepository;
import com.back.backend_springboot.domain.repository.UserRoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity findByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found."));
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    }

    public UserEntity saveUser(UserEntity user) {
        // Encriptar la contraseña antes de guardar el usuario
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        // Establecer locked y disabled a false por defecto
        user.setLocked(false);
        user.setDisabled(false);
        
        UserEntity savedUser = userRepository.save(user);

        // Asignar rol de CUSTOMER al usuario recién creado
        UserRoleEntity userRole = new UserRoleEntity();
        userRole.setRole("CUSTOMER");
        userRole.setGrantedDate(LocalDateTime.now());
        userRole.setUser(savedUser);

        userRoleRepository.save(userRole);

        return savedUser;
    }

    public UserEntity updateUser(Long id, UserEntity userDetails) {
        UserEntity user = getUserById(id);
        user.setUsername(userDetails.getUsername());
        // Encriptar la nueva contraseña antes de guardar
        user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        user.setEmail(userDetails.getEmail());
        user.setLocked(userDetails.getLocked());
        user.setDisabled(userDetails.getDisabled());
        return saveUser(user);
    }

    public void deleteUser(Long id) {
        UserEntity user = getUserById(id);
        userRepository.delete(user);
    }
}

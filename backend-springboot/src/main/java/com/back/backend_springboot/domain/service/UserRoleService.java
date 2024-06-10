package com.back.backend_springboot.domain.service;

import com.back.backend_springboot.application.exception.ResourceNotFoundException;
import com.back.backend_springboot.domain.model.UserRoleEntity;
import com.back.backend_springboot.domain.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService {
    
    @Autowired
    private UserRoleRepository userRoleRepository;

    public List<UserRoleEntity> getAllUserRoles() {
        return userRoleRepository.findAll();
    }

    public UserRoleEntity getUserRoleById(Long id) {
        return userRoleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserRole not found with id " + id));
    }

    public UserRoleEntity saveUserRole(UserRoleEntity userRole) {
        return userRoleRepository.save(userRole);
    }

    public UserRoleEntity updateUserRole(Long id, UserRoleEntity userRoleDetails) {
        UserRoleEntity userRole = getUserRoleById(id);
        userRole.setRole(userRoleDetails.getRole());
        userRole.setGrantedDate(userRoleDetails.getGrantedDate());
        userRole.setUser(userRoleDetails.getUser());
        return saveUserRole(userRole);
    }

    public void deleteUserRole(Long id) {
        UserRoleEntity userRole = getUserRoleById(id);
        userRoleRepository.delete(userRole);
    }
}

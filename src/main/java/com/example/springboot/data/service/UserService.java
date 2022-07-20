package com.example.springboot.data.service;

import com.example.springboot.data.entities.Role;
import com.example.springboot.data.entities.User;
import com.example.springboot.data.entities.UserRole;
import com.example.springboot.data.repositories.RoleRepository;
import com.example.springboot.data.repositories.UserRepository;
import com.example.springboot.data.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    public List<Role> getListRole() {
        return StreamSupport
                .stream(roleRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

    }

    public User findUserByUsername(String username) {
        return StreamSupport
                .stream(userRepository.findUsersByUsername(username).spliterator(), false)
                .findFirst().orElse(null);
    }

    public List<Role> getActiveListRole(int userId) {
        List<UserRole> listUserRoles = StreamSupport
                .stream(userRoleRepository.findUserRolesById(userId).spliterator(), false).collect(Collectors.toList());

        return getListRole().stream().filter(role -> {
            return (listUserRoles.stream().filter(userRole -> userRole.getRoleId() == role.getId()).findFirst().orElse(null) != null);
        }).collect(Collectors.toList());
    }


}

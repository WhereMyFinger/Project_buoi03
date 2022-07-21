package com.example.springboot.data.service;

import com.example.springboot.data.entities.User;
import com.example.springboot.data.repositories.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    public static final Logger logger = LogManager.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findUserById(int id) {
        return userRepository.findById(id).get();
    }

    public Page<User> findUsersByRole(Pageable pageable, int role) {
        return userRepository.findUsersByRole(pageable, role);
    }

    public User findUserByEmail(String email) {
        return StreamSupport
                .stream(userRepository.findByEmail(email).spliterator(), false)
                .findFirst().orElse(null);
    }

    public User findUserByUsername(String username) {
        return StreamSupport
                .stream(userRepository.findUsersByUsername(username).spliterator(), false)
                .findFirst().orElse(null);
    }

    public Page<User> findUserByNameContaining(Pageable pageable, String name) {
        return userRepository.findUsersByUsernameContaining(pageable, name);
    }


    /*public List<Role> getListRole() {
        return StreamSupport
                .stream(roleRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public List<Role> getActiveListRole(int userId) {
        List<UserRole> listUserRoles = StreamSupport
                .stream(userRoleRepository.findUserRolesByUserId(userId).spliterator(), false).collect(Collectors.toList());

        return getListRole().stream().filter(role -> {
            return (listUserRoles.stream().filter(userRole -> userRole.getRoleId() == role.getId()).findFirst().orElse(null) != null);
        }).collect(Collectors.toList());
    }
*/

    public String addNewUser(User user) {
        logger.info("Start registerNewUser");
        try {
            // check existed user
            if(findUserByUsername(user.getUsername()) != null) {
                return "Existed username";
            }

            if(findUserByEmail(user.getEmail()) != null) {
                return "Existed email";
            }

            // hash pass
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setCreated_at(new Date());
            user.setIs_del_flg(false);

            // save user
            userRepository.save(user);

            return "Success";
        } catch (Exception ex) {
            logger.info("Exception on registerNewUser: " + ex.getMessage());
            return "Error on system";
        }
    }

    public boolean updateUser(User user) {
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(int id) {
        User user = userRepository.findById(id).get();
        user.setIs_del_flg(true);
        userRepository.save(user);
    }
}

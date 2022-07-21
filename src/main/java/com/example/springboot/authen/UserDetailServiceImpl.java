package com.example.springboot.authen;

import com.example.springboot.data.entities.User;
import com.example.springboot.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userService.findUserByUsername(s);
        if(user != null) {

            List<Role> listActiveRoles = userService.getActiveListRole(user.getId());
            boolean isActive = true;

            if(listActiveRoles.size() == 0) {
                isActive = false;
            }

            // roles set
            Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
            for (Role role : listActiveRoles) {
                setAuths.add(new SimpleGrantedAuthority(role.getName()));
            }

            // make user for spring-security
            org.springframework.security.core.userdetails.User userDetail =
                    new org.springframework.security.core.userdetails.User(s, user.getPassword(),
                            isActive, true, true, true, setAuths);

            return userDetail;
        }
        throw new UsernameNotFoundException(s + " not found");
    }
}

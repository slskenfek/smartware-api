package com.smart.ware.config.security;

import com.smart.ware.users.dto.UserResponse;
import com.smart.ware.users.repository.UserRepository;
import com.smart.ware.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserResponse users = userService.getUsers(username);

        if (users == null) throw new NullPointerException("해당 유저 정보가 존재 하지 않습니다. userId " + username);

        var authoritiesRole = users.roles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .toList();

        return new User(
                users.userId(),
                users.password(),
                authoritiesRole
        );
    }
}

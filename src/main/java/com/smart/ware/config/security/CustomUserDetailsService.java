package com.smart.ware.config.security;

import com.smart.ware.users.dto.UserView;
import com.smart.ware.users.repository.UserQueryRepository;
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

    private final UserQueryRepository userQueryRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserView users = userQueryRepository.findByUserId(username);

        if (users == null) throw new NullPointerException("해당 유저 정보가 존재 하지 않습니다. userId " + username);

        var authoritiesRole = users.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .toList();

        return new User(
                users.getUserId(),
                users.getPassword(),
                authoritiesRole
        );
    }
}

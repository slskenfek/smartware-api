package com.smart.ware.domain.users.dto;


import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class UserView {
    private Long id;
    private String userId;
    private String password;
    private List<String> roles;
}

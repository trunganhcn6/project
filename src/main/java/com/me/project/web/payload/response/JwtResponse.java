package com.me.project.web.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
public class JwtResponse {
    @Getter @Setter
    private String token;
    @Getter @Setter
    private Integer id;
    @Getter @Setter
    private String username;
    @Getter @Setter
    private String email;
    @Getter
    private List<String> role;

}

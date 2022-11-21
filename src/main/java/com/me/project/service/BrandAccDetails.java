package com.me.project.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.me.project.entity.BrandAcc;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@NoArgsConstructor @AllArgsConstructor
public class BrandAccDetails implements UserDetails {
    @Serial
    private static final long serialVersionUID = 2L;

    private Integer id;

    private String username;

    private String email;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public static BrandAccDetails build(BrandAcc brandAcc){
        List<GrantedAuthority> authorities = Stream.of(brandAcc.getRole())
                .map(role -> new SimpleGrantedAuthority("BRAND")).collect(Collectors.toList());
        return new BrandAccDetails((brandAcc.getId()), brandAcc.getUsername(), brandAcc.getEmail(), brandAcc.getPassword(), authorities);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

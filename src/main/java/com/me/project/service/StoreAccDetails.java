package com.me.project.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.me.project.entity.Store;
import com.me.project.entity.StoreAcc;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor @NoArgsConstructor
public class StoreAccDetails implements UserDetails {
    @Serial
    private static final long serialVersionUID = 1L;

    @Getter
    private Integer id;
    @Getter
    private String username;
    @Getter
    private String email;

    @JsonIgnore
    @Getter
    private String password;

    @Getter
    private Store store;

    @Getter
    private Collection<? extends GrantedAuthority> authorities;

    //Map Set<Role> -> List<GrantedAuthority> in order to work with Authentication obj
    public static StoreAccDetails build(StoreAcc storeAcc){
        List<GrantedAuthority> authorities = Stream.of(storeAcc.getRole())
                .map(role -> new SimpleGrantedAuthority("STORE"))
                .collect(Collectors.toList());
        return new StoreAccDetails((storeAcc.getId()), storeAcc.getUsername(), storeAcc.getEmail(), storeAcc.getPassword(), storeAcc.getStore(), authorities);
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        } else if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(id,((StoreAccDetails) obj).id);
    }
}

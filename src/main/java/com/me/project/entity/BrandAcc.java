package com.me.project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class BrandAcc {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    private String username;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @NotBlank
    private String role = "BRAND";

    /*public List<String> getRole() {
        role.add("BRAND");
        return role;
    }*/
}

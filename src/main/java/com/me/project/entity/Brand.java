package com.me.project.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Brand {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @OneToMany(mappedBy = "brand")
    private List<BrandAcc> brandAccs = new ArrayList<>();

    @OneToMany(mappedBy = "brand", orphanRemoval = true)
    private Set<BrandProduct> brandProducts = new LinkedHashSet<>();

}

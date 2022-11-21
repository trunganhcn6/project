package com.me.project.entity;

import lombok.AllArgsConstructor;
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
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Store {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    private String address;

//    @NotBlank
//    private Integer productId;

    //Mapping One-to-Many to StoreAcc
    @OneToMany(mappedBy = "store")
    private List<StoreAcc> storeAccs = new ArrayList<>();

    @OneToMany(mappedBy = "store", orphanRemoval = true)
    private Set<StoreProduct> storeProducts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "store", orphanRemoval = true)
    private Set<Request> requests = new LinkedHashSet<>();

}

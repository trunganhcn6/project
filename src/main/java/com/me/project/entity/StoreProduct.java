package com.me.project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter @Setter
public class StoreProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @NotNull
    @NotBlank
    private Integer quantity;

    @NotBlank
    private String name;

    @NotBlank
    private Integer price;

    @OneToOne(mappedBy = "storeProduct", orphanRemoval = true)
    private BrandProduct brandProduct;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "storeProduct", orphanRemoval = true)
    private Set<RequestDetails> requestDetails = new LinkedHashSet<>();

}

package com.me.project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter @Setter
public class BrandProduct {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @NotBlank
    private String name;

    private String description;

    @NotBlank
    private Integer pricePerUnit;

    @NotBlank
    private Integer timeToProduce;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "store_product", unique = true)
    private StoreProduct storeProduct;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private Size size;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

}

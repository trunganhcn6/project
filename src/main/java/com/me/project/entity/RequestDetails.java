package com.me.project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter @Setter
@Table(name = "request_details")
public class RequestDetails {
    @Id    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "store_product_id")
    private StoreProduct storeProduct;

    @ManyToOne
    @JoinColumn(name = "request_id")
    private Request request;

}
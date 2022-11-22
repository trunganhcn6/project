package com.me.project.repository;

import com.me.project.entity.StoreProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreProductRepos extends JpaRepository<StoreProduct, Integer> {
    List<StoreProduct> findAll();

}

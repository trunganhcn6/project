package com.me.project.repository;

import com.me.project.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepos extends JpaRepository<Brand, Integer> {
    boolean existsByName(String name);
}

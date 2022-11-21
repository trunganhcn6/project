package com.me.project.repository;

import com.me.project.entity.BrandAcc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandAccRepos extends JpaRepository<BrandAcc, Integer> {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    BrandAcc findByUsername(String username);
}

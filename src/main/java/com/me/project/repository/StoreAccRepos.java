package com.me.project.repository;

import com.me.project.entity.StoreAcc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreAccRepos extends JpaRepository<StoreAcc,Integer> {
    StoreAcc findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);



}

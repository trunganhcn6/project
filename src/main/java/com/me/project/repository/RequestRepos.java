package com.me.project.repository;

import com.me.project.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepos extends JpaRepository<Request, Integer> {
    @Override
    List<Request> findAll();


}

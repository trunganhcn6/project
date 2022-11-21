package com.me.project.controller;

import com.me.project.entity.BrandProduct;
import com.me.project.repository.BrandAccRepos;
import com.me.project.service.BrandProductService;
import com.me.project.web.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    BrandAccRepos brandAccRepos;

    @Autowired
    BrandProductService brandProductService;

    @Autowired
    JwtUtils jwtUtils;

    @GetMapping("/product")
    @PreAuthorize("hasRole('BRAND')")
    public List<BrandProduct> getProductList(){
        return brandProductService.getBrandProducts();
    }


}

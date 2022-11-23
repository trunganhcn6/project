package com.me.project.service;

import com.me.project.entity.BrandProduct;
import com.me.project.repository.BrandAccRepos;
import com.me.project.repository.BrandProductRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class BrandProductService {
    @Autowired
    BrandAccRepos brandAccRepos;

    @Autowired
    BrandProductRepos brandProductRepos;

    @Autowired
    EntityManager entityManager;

    //Get all Products from all Brands
    public List<BrandProduct> getBrandProducts(){
        return brandProductRepos.findAll();
    }

    //Get all Products from 1 Brand
    public List<BrandProduct> getAllBrandProduct(Integer brandId){
        return brandProductRepos.findByBrand_Id(brandId);
    }

    //Get 1 Product from 1 Brand
    public BrandProduct getABrandProduct(Integer brandId, Integer productId){
        return brandProductRepos.findById(productId).orElseThrow();
    }

    //
/*
    public List<BrandProduct> getAllBrandProducts(Integer brandProductId){

*/
//    }
}

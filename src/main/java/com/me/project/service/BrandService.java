package com.me.project.service;

import com.me.project.entity.BrandProduct;
import com.me.project.repository.BrandAccRepos;
import com.me.project.repository.BrandProductRepos;
import com.me.project.repository.BrandRepos;
import com.me.project.dto.BrandProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BrandService {
    @Autowired
    BrandRepos brandRepos;

    @Autowired
    BrandAccRepos brandAccRepos;

    @Autowired
    BrandProductRepos brandProductRepos;


    /* BRAND PRODUCT CRUD */
    //Get all
    public List<BrandProduct> getAllBrandProduct(){
        return brandProductRepos.findAll();
    }

    //Get one
    public BrandProduct getBrandProduct(Integer id) throws NoSuchElementException {
        return brandProductRepos.findById(id).orElseThrow();
    }

    //Create Brand Product =
    public boolean createBrandProduct(BrandProductDto brandProductDto){
        if (brandProductRepos.findByName(brandProductDto.getName()) != null)
            return false;
        else {
//            BrandProduct brandProduct = new BrandProduct();
//            brandProduct = brandProductMapper.brandProductDtoToBrandProduct(brandProductDto);
            return true;
        }
    }

}

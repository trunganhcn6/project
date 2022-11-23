package com.me.project.repository;

import com.me.project.entity.BrandProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandProductRepos extends JpaRepository<BrandProduct, Integer> {

    List<BrandProduct> findByBrand_Id(Integer id);

    BrandProduct findByName(String name);



//    List<BrandProduct> findByProduct_id(Integer brandProductId);

}

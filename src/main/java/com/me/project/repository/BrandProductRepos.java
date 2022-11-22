package com.me.project.repository;

import com.me.project.entity.BrandProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BrandProductRepos extends JpaRepository<BrandProduct, Integer> {

    List<BrandProduct> findByBrand_Id(Integer id);

    Optional<BrandProduct> findByBrand_IdAndProducts_Id(Integer id, Integer id1);


//    List<BrandProduct> findByProduct_id(Integer brandProductId);

}

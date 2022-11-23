package com.me.project.controller;

import com.me.project.entity.Brand;
import com.me.project.entity.Request;
import com.me.project.entity.StoreProduct;
import com.me.project.repository.BrandRepos;
import com.me.project.repository.StoreProductRepos;
import com.me.project.repository.StoreRepos;
import com.me.project.service.RequestService;
import com.me.project.service.StoreService;
import com.me.project.web.payload.request.BrandDTO;
import com.me.project.web.payload.request.RequestDto;
import com.me.project.web.payload.request.StoreProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/store")
@PreAuthorize("hasRole('STORE')")
public class StoreController {
    @Autowired
    StoreProductRepos storeProductRepos;

    @Autowired
    StoreRepos storeRepos;

    @Autowired
    BrandRepos brandRepos;

    @Autowired
    StoreService storeService;

    @Autowired
    RequestService requestService;

    /* STORE PRODUCT CRUD */
    //Get all
    @GetMapping("/product")
    public List<StoreProduct> getAllStoreProduct() {
        return storeService.getAllStoreProduct();
    }

    //Get one
    @GetMapping("/product/{productId}")
    public StoreProduct getStoreProduct(@PathVariable Integer id) {
        return storeService.getStoreProduct(id);
    }

    //Modify Store Product
    @PutMapping("/product/{productId}/update")
    public ResponseEntity<?> modifyStoreProduct(@PathVariable Integer productId, StoreProductDTO newProduct) {
        if (storeService.modifyStoreProduct(productId, newProduct))
            return ResponseEntity.ok().body("Store Product has been updated");
        else return ResponseEntity.badRequest().body("Update failed!");
    }

    //Create Store Product = add new Store Product from Brand Product
    @PostMapping("/product/new")
    public ResponseEntity<?> createStoreProduct(StoreProductDTO storeProductDTO){
        if (storeService.createStoreProduct(storeProductDTO))
            return ResponseEntity.ok("New product: " + storeProductDTO.getName() + " has been added");
        return ResponseEntity.badRequest().body("Failed to add");
    }

    //


    /*public ResponseEntity<?> createStoreProduct(@PathVariable StoreProduct storeProduct){
        if(storeService.createStoreProduct(storeProduct))
            return ResponseEntity.ok(storeProduct.getQuantity() + " " + storeProduct.getName() + " has been added");
        else return ResponseEntity.badRequest().body("Failed to add new Store Product");
    }*/

    /********************************/

    /* REQUEST CRUD */
    //Get all Request
    @GetMapping("/request")
    public List<Request> getAllRequest() {
        return storeService.getAllRequest();
    }

    //Get a Request
    @GetMapping("/request/{requestId}")
    public Request getRequest(@PathVariable Integer requestId){
        return storeService.getRequest(requestId);
    }

    //Create Request
    @PostMapping("/request/new")
    public ResponseEntity<?> createRequest(Request request){
        if (storeService.createRequest(request))
            return ResponseEntity.ok("Request sent");
        else return ResponseEntity.badRequest().body("Error while creating Request!");
    }

    //Modify Request
    @PutMapping("/request/{requestId}")
    public Request modifyRequest(Integer requestId, RequestDto requestDto){
        return  (storeService.modifyRequest(requestId, requestDto));
    }

    //Delete Request
//    @DeleteMapping("/request/{requestId}")


    /********************************/

    //Create Brand
    @PostMapping("/brand/new")
    public ResponseEntity<?> createBrand(@RequestBody BrandDTO brandDTO) {
        if (brandRepos.existsByName(brandDTO.getName())) {
            return ResponseEntity.badRequest().body("Error: Brand name is not available");
        }

        Brand brand = new Brand();
        brand.setAddress(brandDTO.getAddress());
        brand.setName(brandDTO.getName());
        brandRepos.save(brand);
        return ResponseEntity.ok().body("Create new Brand :" + brandDTO.getName());
    }

    //Get all Brand
    @GetMapping("/brand")
    public List<Brand> getAllBrand(){
        return brandRepos.findAll();
    }



    /********************************/

    /* Manage Order */
 /*   @PostMapping("/store/request")
    @PreAuthorize("hasRole('STORE')")*/

}

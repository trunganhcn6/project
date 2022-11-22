package com.me.project.service;

import com.me.project.entity.Request;
import com.me.project.entity.StoreProduct;
import com.me.project.repository.RequestRepos;
import com.me.project.repository.StoreProductRepos;
import com.me.project.web.payload.request.RequestDto;
import com.me.project.web.payload.request.StoreProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    @Autowired
    StoreProductRepos storeProductRepos;

    @Autowired
    RequestRepos requestRepos;

    /* STORE PRODUCT CRUD */
    //Get all
    public List<StoreProduct> getAllStoreProduct() {
        return storeProductRepos.findAll();
    }

    //Get one
    public StoreProduct getStoreProduct(Integer productId) {
        return storeProductRepos.getReferenceById(productId);
    }

    //Modify one
    public boolean modifyStoreProduct(Integer id, StoreProductDTO newProduct) {
        if (newProduct.getPrice() > 0 && newProduct.getQuantity() >= 0) {
            StoreProduct existedProduct = storeProductRepos.getReferenceById(id);
            existedProduct.setName(newProduct.getName());
            existedProduct.setPrice(newProduct.getPrice());
            existedProduct.setQuantity(newProduct.getQuantity());
            storeProductRepos.save(existedProduct);
            return true;
        } else return false;
    }

    /********************************/

    /* REQUEST CRUD */
    //Get Request
    public Request getRequest(Integer requestId){
        return requestRepos.getReferenceById(requestId);
    }

    //Get all request
    public List<Request> getAllRequest(){
        return requestRepos.findAll(Sort.sort(Request.class));
    }

    //Create Request
    public boolean createRequest(Request request){
        return false;
    }

    //Modify Request
    public Request modifyRequest(Integer requestId, RequestDto requestDto){
        return new Request();
    }
    /********************************/
}

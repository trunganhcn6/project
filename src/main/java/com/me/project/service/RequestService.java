package com.me.project.service;

import com.me.project.entity.Request;
import com.me.project.repository.RequestRepos;
import com.me.project.repository.StoreProductRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {
    @Autowired
    StoreProductRepos storeProductRepos;

    @Autowired
    RequestRepos requestRepos;

    //Get all Request
    public List<Request> getAllRequest(){
        return requestRepos.findAll();
    }

    //Create new Request
    public void createRequest(Request request){
        requestRepos.save(request);
    }

}

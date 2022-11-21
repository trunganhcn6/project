package com.me.project.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class DefaultController {
    @GetMapping("/store")
    @PreAuthorize("hasRole('STORE')")
    public String storeBoard(){
        return "Store...";
    }
}

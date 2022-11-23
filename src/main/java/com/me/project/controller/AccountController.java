package com.me.project.controller;

import com.me.project.entity.BrandAcc;
import com.me.project.entity.StoreAcc;
import com.me.project.repository.*;
import com.me.project.service.BrandAccDetails;
import com.me.project.service.StoreAccDetails;
import com.me.project.web.jwt.JwtUtils;
import com.me.project.dto.BrandAccDTO;
import com.me.project.dto.StoreAccDTO;
import com.me.project.web.payload.response.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AccountController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    StoreAccRepos storeAccRepos;

    @Autowired
    BrandAccRepos brandAccRepos;

    @Autowired
    StoreRepos storeRepos;

    @Autowired
    BrandRepos brandRepos;

    @Autowired
    StoreProductRepos storeProductRepos;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    /* authenticate { username, password }
    update SecurityContext using Authentication object
    generate JWT
    get UserDetails from Authentication object
    response contains JWT and UserDetails data */
    @PostMapping("/store-account/login")
    public ResponseEntity<?> authenticateStore(@Valid @RequestBody StoreAccDTO storeAccDTO) {
        Authentication authentication = authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(storeAccDTO.getUsername(), storeAccDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateStoreJwt(authentication);

        StoreAccDetails storeAccDetails = (StoreAccDetails) authentication.getPrincipal();
        List<String> role = storeAccDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).toList();

        return ResponseEntity.ok(new JwtResponse(jwt, storeAccDetails.getId(), storeAccDetails.getUsername(), storeAccDetails.getEmail(), role));
    }

    @PostMapping("/brand-account/login")
    public ResponseEntity<?> authenticateBrand(@Valid @RequestBody BrandAccDTO brandAccDTO) {
        Authentication authentication = authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(brandAccDTO.getUsername(), brandAccDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateStoreJwt(authentication);

        BrandAccDetails brandAccDetails = (BrandAccDetails) authentication.getPrincipal();
        List<String> role = brandAccDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).toList();

        return ResponseEntity.ok(new JwtResponse(jwt, brandAccDetails.getId(), brandAccDetails.getUsername(), brandAccDetails.getEmail(), role));
    }

/*    @PostMapping("brand/signup")
    public ResponseEntity<?> registerBrand(@Valid @RequestBody BrandAccDTO loginBrandAccountDto) {
        if (brandAccRepos.existsByUsername(loginBrandAccountDto.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }

        if (brandAccRepos.existsByEmail(loginBrandAccountDto.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Email is already in use!");
        }

        BrandAcc brandAcc = new BrandAcc(loginBrandAccountDto.getUsername(), loginBrandAccountDto.getEmail(), encoder.encode(loginBrandAccountDto.getPassword()), "BRAND", );
        return null;
    }*/

    //Create StoreAcc
    @PostMapping("store-account/new")
    @PreAuthorize("hasRole('STORE')")
    public ResponseEntity<?> registerStore(@RequestBody StoreAccDTO storeAccDTO) {
        if (storeAccRepos.existsByUsername(storeAccDTO.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }

        if (storeAccRepos.existsByEmail(storeAccDTO.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Email is already in use!");
        }

        StoreAcc storeAcc = new StoreAcc();
        if(storeAccRepos.findById(1).isPresent()) {
            storeAcc.setStore(storeRepos.findById(1).get());
        } else ResponseEntity.badRequest().body("Error: No store is found!");

        storeAcc.setRole("STORE");
        storeAcc.setUsername(storeAccDTO.getUsername());
        storeAcc.setPassword(encoder.encode(storeAccDTO.getPassword()));
        storeAcc.setEmail(storeAccDTO.getEmail());
        storeAccRepos.save(storeAcc);
        return ResponseEntity.ok().body("Store Account registered!");
    }

    //Create BrandAcc
    @PostMapping("brand-account/new")
    @PreAuthorize("hasRole('STORE')")
    public ResponseEntity<?> registerBrand(@RequestBody BrandAccDTO brandAccDTO) {
        if (brandAccRepos.existsByUsername(brandAccDTO.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }

        if (brandAccRepos.existsByEmail(brandAccDTO.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Email is already in use!");
        }

        BrandAcc brandAcc = new BrandAcc();

        brandAcc.setRole("BRAND");
        brandAcc.setBrand(brandRepos.findById(brandAccDTO.getBrandId()).get());
        brandAcc.setUsername(brandAccDTO.getUsername());
        brandAcc.setPassword(encoder.encode(brandAccDTO.getPassword()));
        brandAcc.setEmail(brandAccDTO.getEmail());
        brandAccRepos.save(brandAcc);
        return ResponseEntity.ok().body("Brand Account registered!");
    }


}
package com.me.project.controller;

import com.me.project.entity.Store;
import com.me.project.entity.StoreAcc;
import com.me.project.repository.BrandAccRepos;
import com.me.project.repository.StoreAccRepos;
import com.me.project.repository.StoreRepos;
import com.me.project.service.BrandAccDetails;
import com.me.project.service.StoreAccDetails;
import com.me.project.web.jwt.JwtUtils;
import com.me.project.web.payload.request.LoginBrandAccountDto;
import com.me.project.web.payload.request.LoginStoreAccountDto;
import com.me.project.web.payload.response.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    StoreAccRepos storeAccRepos;

    @Autowired
    BrandAccRepos brandAccRepos;

    @Autowired
    StoreRepos storeRepos;

 /*   @Autowired
    PasswordEncoder encoder;*/

    @Autowired
    JwtUtils jwtUtils;

    /* authenticate { username, password }
    update SecurityContext using Authentication object
    generate JWT
    get UserDetails from Authentication object
    response contains JWT and UserDetails data */
    @PostMapping("/store/sign-in")
    public ResponseEntity<?> authenticateStore(@Valid @RequestBody LoginStoreAccountDto loginStoreAccountDto) {
        Authentication authentication = authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(loginStoreAccountDto.getUsername(), loginStoreAccountDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateStoreJwt(authentication);

        StoreAccDetails storeAccDetails = (StoreAccDetails) authentication.getPrincipal();
        List<String> role = storeAccDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).toList();

        return ResponseEntity.ok(new JwtResponse(jwt, storeAccDetails.getId(), storeAccDetails.getUsername(), storeAccDetails.getEmail(), role));
    }

    @PostMapping("/brand/sign-in")
    public ResponseEntity<?> authenticateBrand(@Valid @RequestBody LoginBrandAccountDto loginBrandAccountDto) {
        Authentication authentication = authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(loginBrandAccountDto.getUsername(), loginBrandAccountDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateStoreJwt(authentication);

        BrandAccDetails brandAccDetails = (BrandAccDetails) authentication.getPrincipal();
        List<String> role = brandAccDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).toList();

        return ResponseEntity.ok(new JwtResponse(jwt, brandAccDetails.getId(), brandAccDetails.getUsername(), brandAccDetails.getEmail(), role));
    }

/*    @PostMapping("brand/signup")
    public ResponseEntity<?> registerBrand(@Valid @RequestBody LoginBrandAccountDto loginBrandAccountDto) {
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

    @PostMapping("store/signup")
    public ResponseEntity<?> registerStore(@RequestBody LoginStoreAccountDto loginStoreAccountDto) {
        if (brandAccRepos.existsByUsername(loginStoreAccountDto.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }

        if (brandAccRepos.existsByEmail(loginStoreAccountDto.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Email is already in use!");
        }

        StoreAcc storeAcc = new StoreAcc();
        storeAcc.setStore(storeRepos.findById(1));

    }
}
package com.me.project.service;

import com.me.project.entity.BrandAcc;
import com.me.project.repository.BrandAccRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BrandAccDetailsService implements UserDetailsService {
    @Autowired
    private BrandAccRepos brandAccRepos;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BrandAcc brandAcc = brandAccRepos.findByUsername(username);
        if (brandAcc == null){
            throw new UsernameNotFoundException("Can not find brand" + username);
        }
        return BrandAccDetails.build(brandAcc);
    }
}

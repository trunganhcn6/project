package com.me.project.service;

import com.me.project.entity.StoreAcc;
import com.me.project.repository.StoreAccRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StoreAccDetailsService implements UserDetailsService {
    @Autowired
    private StoreAccRepos storeAccRepos;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        StoreAcc storeAcc = storeAccRepos.findByUsername(username);
        if (storeAcc == null){
            throw new UsernameNotFoundException("Can not find store " + username);
        }
        return StoreAccDetails.build(storeAcc);
    }
}

/*
package com.me.project.config;

import com.me.project.entity.Privilege;
import com.me.project.entity.Role;
import com.me.project.entity.User;
import com.me.project.repository.PrivilegeRepos;
import com.me.project.repository.RoleRepos;
import com.me.project.repository.StoreAccRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    boolean isSetup = false;

    @Autowired
    private StoreAccRepos userRepos;

    @Autowired
    private RoleRepos roleRepos;

    @Autowired
    private PrivilegeRepos privilegeRepos;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (isSetup) return;
        Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        List<Privilege> adminPrivilege = Arrays.asList(readPrivilege,writePrivilege);
        createRoleIfNotFound("ROLE_ADMIN", adminPrivilege);
        createRoleIfNotFound("ROLE_USER",Arrays.asList(readPrivilege));

        Role adminRole = roleRepos.findByName("ROLE_ADMIN");
        User user = new User();
        user.set
    }

    @Transactional
    Privilege createPrivilegeIfNotFound(String name){
        Privilege privilege = privilegeRepos.findByName(name);
        if (privilege == null){
            privilege = new Privilege(name);
            privilegeRepos.save(privilege);
        }
        return privilege;
    }
}
*/

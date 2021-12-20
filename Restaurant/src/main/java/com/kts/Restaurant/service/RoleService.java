package com.kts.Restaurant.service;

import com.kts.Restaurant.model.Role;
import com.kts.Restaurant.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public void createRoles(){
        roleRepository.createRolesDB();
    }

    public List<Role> getAll(){
        return roleRepository.getAll();
    }

//    public Role saveRole(Role role) {
//        return roleRepository.save(role);
//    }
}

package com.kts.Restaurant.controller;


import com.kts.Restaurant.model.Role;
import com.kts.Restaurant.service.RoleService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="api/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Role>> getAll(){
        List<Role> roles = roleService.getAll();
        if(!roles.isEmpty())
            return new ResponseEntity<>(roles, HttpStatus.OK);
        roleService.createRoles();
        roles = roleService.getAll();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @RequestMapping(value = "/createRoles", method = RequestMethod.GET)
    public ResponseEntity<Void> createRoles(){
        roleService.createRoles();
        return ResponseEntity.ok().build();

    }

}

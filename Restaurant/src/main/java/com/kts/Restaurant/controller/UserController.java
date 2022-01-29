package com.kts.Restaurant.controller;


import com.kts.Restaurant.dto.UserDTO;
import com.kts.Restaurant.exceptions.UserWIthUsernameNotFound;
import com.kts.Restaurant.exceptions.UserWithUsernameAlreadyExistsException;
import com.kts.Restaurant.model.Role;
import com.kts.Restaurant.model.User;
import com.kts.Restaurant.service.RoleService;
import com.kts.Restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

//    @CrossOrigin(origins = "http://localhost:4200")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) {

        UserDTO user;
        try {
            user = userService.create(userDTO);
            return new ResponseEntity<>(user, HttpStatus.OK);

        }catch (UserWithUsernameAlreadyExistsException e){
            return new ResponseEntity<>(userDTO, HttpStatus.BAD_REQUEST);
        }
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO) {
        UserDTO user;
        try {
            user = userService.update(userDTO);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (UserWIthUsernameNotFound | UserWithUsernameAlreadyExistsException e){
            return new ResponseEntity<>(userDTO, HttpStatus.BAD_REQUEST);
        }

    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @RequestMapping(value = "/fire", method = RequestMethod.PUT)
    public ResponseEntity<UserDTO> fire(@RequestBody UserDTO userDTO) {
        UserDTO user;
        try {
        	user = null;
            //user = userService.logicalDelete(userDTO.getUsername());
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (UserWIthUsernameNotFound e){
            return new ResponseEntity<>(userDTO, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> getALl(){
        List<UserDTO> dtos = userService.getAll();
        if(dtos.size() == 0) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getById(@PathVariable Long id){
        UserDTO dto = userService.findById(id);
        if(dto == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }



    @RequestMapping(value = "/getAllByRole", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> getALl(@RequestParam String role){
        List<UserDTO> dtos = userService.getAllByRole(role);
        if(dtos == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }


}

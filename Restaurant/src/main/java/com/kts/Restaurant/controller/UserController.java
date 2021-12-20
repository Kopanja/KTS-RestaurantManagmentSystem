package com.kts.Restaurant.controller;


import com.kts.Restaurant.dto.UserDTO;
import com.kts.Restaurant.exceptions.UserWIthUsernameNotFound;
import com.kts.Restaurant.exceptions.UserWithUsernameAlreadyExistsException;
import com.kts.Restaurant.model.User;
import com.kts.Restaurant.service.RoleService;
import com.kts.Restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="api/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

//    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) {

        UserDTO user;
        try {
            user = userService.createUser(userDTO);
            return new ResponseEntity<>(user, HttpStatus.OK);

        }catch (UserWithUsernameAlreadyExistsException e){
            return new ResponseEntity<>(userDTO, HttpStatus.BAD_REQUEST);

        }

    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO) {
        UserDTO user;
        try {
            user = userService.updateUser(userDTO);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (UserWIthUsernameNotFound | UserWithUsernameAlreadyExistsException e){
            return new ResponseEntity<>(userDTO, HttpStatus.BAD_REQUEST);
        }

    }


}

package com.kts.Restaurant.service;

import com.kts.Restaurant.dto.UserDTO;
import com.kts.Restaurant.exceptions.UserWIthUsernameNotFound;
import com.kts.Restaurant.exceptions.UserWithUsernameAlreadyExistsException;
import com.kts.Restaurant.model.Role;
import com.kts.Restaurant.model.Salary;
import com.kts.Restaurant.model.User;
import com.kts.Restaurant.repository.RoleRepository;
import com.kts.Restaurant.repository.UserRepository;
import com.kts.Restaurant.util.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SalaryService salaryService;

    @Autowired
    RoleRepository roleRepository;

    public UserDTO createUser(UserDTO userDTO) {

        //if username already exists
        if (userRepository.findByUsername(userDTO.getUsername()) != null) {
            throw new UserWithUsernameAlreadyExistsException();
        }
        User newUser = new User();

        // new Salary
        Salary salary = new Salary();
        salary.setActive(true);
        salary.setSalaryAmount(userDTO.getSalaryAmount());
        salary.setSince(new Date());
        List salaries = new ArrayList<>();
        salaries.add(salary);
        newUser.setSalaries(salaries);

        // other
        newUser.setFirstname(userDTO.getFirstname());
        newUser.setLastname(userDTO.getLastname());
        newUser.setUsername(userDTO.getUsername());
        newUser.setPassword(userDTO.getPassword());
        newUser.setPin(userDTO.getPin());

        // role
        Role role = roleRepository.findByRole(userDTO.getRole());
        newUser.setRole(role);
        userRepository.save(newUser);
//        return new UserDTO(newUser.getFirstname(), newUser.getLastname(), newUser.getUsername(), newUser.getPassword(), newUser.getRole().getRole(), newUser.getPin(),salary.getSalaryAmount());
        UserMapper userMapper = new UserMapper();
        return userMapper.toDto(newUser);
    }



    public UserDTO updateUser (UserDTO userDTO){

        // dobavi User obj iz baze
        // uporedi mu value polja, sta se razlikuje, to treba da se apdejtuje
        // prodji tako kroz sve atribute
        // ako je salary diff, treba nov objekat i ovo an false i 'to' do now
        // save nazad User u bazu
        // vrati userDTO

        User user = userRepository.findByUsername(userDTO.getUsername());
        if(user == null){
            throw new UserWIthUsernameNotFound();
        }
        //username check is free
//        if (userDTO.getUsername() != user.getUsername()) {
//            if( userRepository.findByUsername(userDTO.getUsername()).hashCode() != user.hashCode()  ){
//                throw new UserWithUsernameAlreadyExistsException();
//            }
//            user.setUsername(userDTO.getUsername());
//        }
        user.setUsername(userDTO.getUsername());

        //set new changes
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        Role roleDb = roleRepository.findByRole(userDTO.getRole());
        user.setRole(roleDb);
        user.setPin(userDTO.getPin());
        user.setPassword(userDTO.getPassword());

        // salary check if amount of active is changed
        Salary salaryDb =  user.getSalaries().stream().filter(s -> s.getActive().equals(true)).findFirst().orElse(null);
        // if true:
        // 1) oldOne active = false && dateTo=now()
        // 2) change in user salaries that one with updated fields
        if(userDTO.getSalaryAmount() != salaryDb.getSalaryAmount()){
            Salary oldOne = salaryDb;
            // changes on User at the end
            // old to false
            // and 'to' date
            // add new Salary
            salaryDb.setSalaryAmount(userDTO.getSalaryAmount());
            salaryDb.setActive(false);
            salaryDb.setTo(new Date());
            //on User
            int index = user.getSalaries().indexOf(oldOne);
            user.getSalaries().add(index, salaryDb);
        }
        userRepository.save(user);
        UserMapper userMapper = new UserMapper();
        return userMapper.toDto(user);


    }


}


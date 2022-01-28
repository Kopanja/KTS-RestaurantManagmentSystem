package com.kts.Restaurant.service;

import com.kts.Restaurant.dto.UserDTO;
import com.kts.Restaurant.dto.UsernamePasswordCredentialsDTO;
import com.kts.Restaurant.exceptions.UserWIthUsernameNotFound;
import com.kts.Restaurant.exceptions.UserWithUsernameAlreadyExistsException;
import com.kts.Restaurant.model.*;
import com.kts.Restaurant.repository.BillRepository;
import com.kts.Restaurant.repository.RoleRepository;
import com.kts.Restaurant.repository.UserRepository;
import com.kts.Restaurant.util.mapper.UserMapper;
import org.apache.commons.lang3.time.DateParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SalaryService salaryService;

    @Autowired
    RoleRepository roleRepository;
    

    @Autowired
    BillRepository billRepository;

    //SVE TREBA DA SE UPDATE ZBOG CREDENTIALS
    
    public User save(User user) {
    	return userRepository.save(user);
    }
    
    
    public UserDTO create(UserDTO userDTO) {

    	
        //if username already exists
        /*
    	if (userRepository.findByUsername(userDTO.getUsername()) != null) {
            throw new UserWithUsernameAlreadyExistsException();
        }
        */
        User newUser = new User();

        // new Salary
        Salary salary = new Salary();
        salary.setActive(true);
        salary.setSalaryAmount(userDTO.getSalaryAmount());
        salary.setSince(new Date());
        List<Salary> salaries = new ArrayList<>();
        salaries.add(salary);
        newUser.setSalaries(salaries);

        // other
        newUser.setFirstname(userDTO.getFirstname());
        newUser.setLastname(userDTO.getLastname());
       
        //Treba da se promeni sa SET CREDENTIALS
        // newUser.setUsername(userDTO.getUsername());
        //newUser.setPassword(userDTO.getPassword());
        //newUser.setPin(userDTO.getPin());

        // role
        Role role = roleRepository.findByRole(userDTO.getRole());
        newUser.setRole(role);
        newUser.setActive(true);
        userRepository.save(newUser);
//        return new UserDTO(newUser.getFirstname(), newUser.getLastname(), newUser.getUsername(), newUser.getPassword(), newUser.getRole().getRole(), newUser.getPin(),salary.getSalaryAmount());
        UserMapper userMapper = new UserMapper();
        return userMapper.toDto(newUser);
    }
    
    
   



    public UserDTO update(UserDTO userDTO){

        // dobavi User obj iz baze
        // uporedi mu value polja, sta se razlikuje, to treba da se apdejtuje
        // prodji tako kroz sve atribute
        // ako je salary diff, treba nov objekat i ovo an false i 'to' do now
        // save nazad User u bazu
        // vrati userDTO

        User user = userRepository.findById(userDTO.getId()).orElse(null);
       // User user = null;
        if(user == null){
            throw new UserWIthUsernameNotFound();
        }


        //set new changes
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        Role roleDb = roleRepository.findByRole(userDTO.getRole());
        user.setRole(roleDb);
       

        Salary salaryDb =  user.getSalaries().stream().filter(s -> s.getActive().equals(true)).findFirst().orElse(null);
        // salary check if amount of active is changed
        // or if user got fired, make
        // if true:
        // 1) oldOne active = false && dateTo=now()
        // 2) change in user salaries that one with updated fields
        if(userDTO.getSalaryAmount() != salaryDb.getSalaryAmount()){
            int index = user.getSalaries().indexOf(salaryDb);
            // changes on User at the end
            // old to false
            // and 'to' date
            // add new Salary
            salaryDb.setActive(false);
            salaryDb.setTo(new Date());
            //salaryService.saveSalary(salaryDb);

            //on User
            user.getSalaries().add(index, salaryDb);
            Salary newSalary = new Salary(userDTO.getSalaryAmount(), new Date(), null, true);
            user.getSalaries().add(newSalary);
        }
        userRepository.save(user);
        UserMapper userMapper = new UserMapper();
        return userMapper.toDto(user);
    }


    // setting active to false
    public UserDTO logicalDelete(String username){
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UserWIthUsernameNotFound();
        }
        Salary salary =  user.getSalaries().stream().filter(s -> s.getActive().equals(true)).findFirst().orElse(null);
        int index = user.getSalaries().indexOf(salary);
        salary.setTo(new Date());
        salary.setActive(false);
        salaryService.saveSalary(salary);
        user.setActive(false);
        userRepository.save(user);
        UserMapper userMapper = new UserMapper();
        return userMapper.toDto(user);
    }


    public List<UserDTO> getAll(){
        List<UserDTO> dtos = new ArrayList<>();
        UserMapper userMapper = new UserMapper();
        List<User> users = userRepository.findAll();
        for (User user: users) {
            dtos.add(userMapper.toDto(user));
        }
        return dtos;
    }

    public List<UserDTO> getAllActive(){
        List<UserDTO> dtos = new ArrayList<>();
        UserMapper userMapper = new UserMapper();
        List<User> users = userRepository.findAll();
        for (User user: users) {
            dtos.add(userMapper.toDto(user));
        }
        return dtos;
    }

    public List<UserDTO> getAllByRole(String roleName){
        List<UserDTO> dtos = new ArrayList<>();
        Role role = roleRepository.findByRole(roleName);
        //List<User> usersa =  userRepository.findAll();

        List<User> users =  userRepository.findAllByRole(role.getRole());
        if(users.size() == 0){
            return null;
        }
        UserMapper userMapper = new UserMapper();
        for (User u: users) {
            dtos.add(userMapper.toDto(u));
        }
        return dtos;

    }
    
    public UserDTO findById(Long id) {
    	User user = userRepository.findById(id).orElse(null);
    	UserMapper userMapper = new UserMapper();
    	return userMapper.toDto(user);
    }
    
    public User findUserEntityById(Long id) {
    	User user = userRepository.findById(id).orElse(null);
    	if(user == null){
            throw new UserWIthUsernameNotFound();
        }
    	return user;
    }
    
    
    public User findByUsername(String username) {
    	User user = userRepository.findByUsername(username);
        return user;
    }
    
    public User findByPin(String pin) {
    	for(User user : userRepository.getAllPinUsers()) {
    		PinCredentials userPin = (PinCredentials) user.getCredentials();
    		if(BCrypt.checkpw(pin, userPin.getPin())){
    			return user;
    		}
    	}
    	return null;
    }
    
    public User findByGeneratedTokenSubject(String tokenSubject) {
    	return userRepository.findByGeneratedTokenSubject(tokenSubject);
    	
    }
    
    public String generateTokenSubjectForPinUser(User user) {
    	return user.getFirstname() + user.getLastname() + user.getRole().getRole() + user.getId();
    }
    
    public List<User> getAllPinBasedUsers(){
        return userRepository.getAllPinUsers();
    }


}


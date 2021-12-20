package com.kts.Restaurant.util.mapper;

import com.kts.Restaurant.dto.UserDTO;
import com.kts.Restaurant.model.Salary;
import com.kts.Restaurant.model.User;
import com.kts.Restaurant.util.DTOMapperInterface;

public class UserMapper implements DTOMapperInterface<User, UserDTO> {
    
    @Override
    public User toEntity(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO toDto(User user) {
        Salary activeSalary =  user.getSalaries().stream().filter(s -> s.getActive().equals(true)).findFirst().orElse(null);
        return new UserDTO(user.getFirstname(), user.getLastname(), user.getUsername(), user.getPassword(), user.getRole().getRole(), user.getPin(), activeSalary.getSalaryAmount(), user.isActive());
    }
}

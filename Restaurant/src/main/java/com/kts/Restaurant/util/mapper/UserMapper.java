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
        double amount;
        // condition for user deletion when there's no activeSalary
        if(activeSalary == null){
            amount = 0;
        }else{
            amount = activeSalary.getSalaryAmount();
        }
        return new UserDTO(user.getId(),user.getFirstname(), user.getLastname(), user.getRole().getRole(), amount, user.isActive());
    }
}

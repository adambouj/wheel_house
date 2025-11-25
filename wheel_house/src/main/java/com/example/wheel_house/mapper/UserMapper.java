package com.example.wheel_house.mapper;

import com.example.wheel_house.dto.UserDto;
import com.example.wheel_house.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto toDto(User user){
        if(user==null) {
            return null;
        }else {
            UserDto dto = new UserDto();
            dto.setUserName(user.getUserName());
            dto.setPassword(user.getPassword());
            return dto;
        }
    }
    public User toUser(UserDto dto){
        if(dto==null) {
            return null;
        }else {

            User u = new User();

            u.setUserName(dto.getUserName());
            u.setPassword(dto.getPassword());
            return u;

        }
    }
}

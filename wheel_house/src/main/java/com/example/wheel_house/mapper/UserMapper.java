package com.example.wheel_house.mapper;

import com.example.wheel_house.dto.UserDto;
import com.example.wheel_house.entity.Role;
import com.example.wheel_house.entity.User;
import com.example.wheel_house.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {
    @Autowired
    RoleRepository rr;

//    public UserDto toDto(User user){
//        if(user==null) {
//            return null;
//        }else {
//            UserDto dto = new UserDto();
//            dto.setUserName(user.getUserName());
//            dto.setPassword(user.getPassword());
//            return dto;
//        }
//    }
//    public User toUser(UserDto dto){
//        if(dto==null) {
//            return null;
//        }else {
//
//            User u = new User();
//
//            u.setUserName(dto.getUserName());
//            u.setPassword(dto.getPassword());
//            return u;
//
//        }
//    }
public User toUser(UserDto dto) {
    if (dto == null) return null;

    User user = new User();
    user.setUserName(dto.getUserName());
    user.setPassword(dto.getPassword());

    // Convert role names → Role entities
    if (dto.getRoles() != null) {
        List<Role> roles = dto.getRoles()
                .stream()
                .map(name -> rr.findByName(name))
                .toList();

        user.setRoles(roles);
    }

    return user;
}

    public UserDto toDto(User user) {
        if (user == null) return null;

        UserDto dto = new UserDto();
        dto.setUserName(user.getUserName());
        dto.setPassword(user.getPassword());

        dto.setRoles(
                user.getRoles().stream()
                        .map(Role::getName)
                        .toList()
        );

        return dto;
    }

}

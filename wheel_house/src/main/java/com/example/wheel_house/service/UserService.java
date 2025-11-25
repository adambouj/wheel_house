package com.example.wheel_house.service;

import com.example.wheel_house.dto.UserDto;
import com.example.wheel_house.entity.User;
import com.example.wheel_house.mapper.UserMapper;
import com.example.wheel_house.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository ur;
    @Autowired
    UserMapper um;

//    void saveUser(User u){
//      ur.save(u);
//    }
 public  void saveUser(UserDto dto){
    User u = um.toUser(dto);
    ur.save(u);
}
    public UserDto getUserById(Long id) {
        User user = ur.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return um.toDto(user);
    }
    public List<UserDto> getAllUsers() {
        return ur.findAll()
                .stream()
                .map(um::toDto)
                .toList();
    }

//    public User updateUser(Long id, User um) {
//        User u = ur.findById(id)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        u.setUserName(um.getUserName());
//        u.setPassword(um.getPassword());
//
//
//        return ur.save(u);
//    }
public UserDto updateUser(Long id, UserDto dto) {

    User u = ur.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));

    u.setUserName(dto.getUserName());
    u.setPassword(dto.getPassword());

    User saved = ur.save(u);
    return um.toDto(saved);
}
    public void deleteUser(Long id) {
        ur.deleteById(id);
    }
}

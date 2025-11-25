package com.example.wheel_house.controller;

import com.example.wheel_house.dto.UserDto;
import com.example.wheel_house.entity.User;
import com.example.wheel_house.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserControler {
    @Autowired
    UserService us;
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id){
        return us.getUserById(id);
    }
    @PostMapping
    public String saveUser(@RequestBody @Valid UserDto dto){
        us.saveUser(dto);
        return "user added";
    }
//    @PutMapping("/{id}")
//    public User updateUser(@PathVariable Long id, @RequestBody User um) {
//        return us.updateUser(id, um);
//    }
    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody @Valid UserDto dto) {
    return us.updateUser(id, dto);
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        us.deleteUser(id);
        return "user deleted successfully";
    }
    @GetMapping
    public List<UserDto> getAllUsers() {
        return us.getAllUsers();
    }
}

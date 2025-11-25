package com.example.wheel_house.controller;

import com.example.wheel_house.dto.RoleDto;
import com.example.wheel_house.dto.UserDto;
import com.example.wheel_house.entity.Role;
import com.example.wheel_house.entity.User;
import com.example.wheel_house.service.RoleService;
import com.example.wheel_house.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleControler {
    @Autowired
    RoleService rs;
    @GetMapping("/{id}")
    public RoleDto getRoleById(@PathVariable Long id){
        return rs.getRoleById(id);
    }
    @PostMapping
    public String saveRole(@RequestBody @Valid RoleDto dto){
        rs.saveRole(dto);
        return "Role added";
    }

    @PutMapping("/{id}")
    public RoleDto updateRole(@PathVariable Long id, @RequestBody @Valid RoleDto dto) {
    return rs.updateRole(id, dto);
    }
    @DeleteMapping("/{id}")
    public String deleteRole(@PathVariable Long id) {
        rs.deleteRole(id);
        return "role deleted successfully";
    }
    @GetMapping
    public List<RoleDto> getAllRoles() {
        return rs.getAllRoles();
    }
}

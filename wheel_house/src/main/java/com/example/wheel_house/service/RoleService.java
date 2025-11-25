package com.example.wheel_house.service;

import com.example.wheel_house.dto.RoleDto;
import com.example.wheel_house.entity.Role;
import com.example.wheel_house.mapper.RoleMapper;
import com.example.wheel_house.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepository rr;
    @Autowired
    RoleMapper rm;
    public void saveRole(RoleDto r){
        Role role = rm.toRole(r);

        rr.save(role);
    }
    public RoleDto getRoleById(Long id) {
        Role role = rr.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        return rm.toDto(role);
    }
        public RoleDto updateRole(Long id, RoleDto dto) {
                Role role = rr.findById(id)
                 .orElseThrow(() -> new RuntimeException("Role not found"));

                role.setName(dto.getName());

            Role saved = rr.save(role);
            return rm.toDto(saved);
    }
    public void deleteRole(Long id) {
        rr.deleteById(id);
    }
    public List<RoleDto> getAllRoles() {
        return rr.findAll().stream()
                .map(rm::toDto)
                .toList();
    }
}

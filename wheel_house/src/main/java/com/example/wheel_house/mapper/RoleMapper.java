package com.example.wheel_house.mapper;

import com.example.wheel_house.dto.RoleDto;
import com.example.wheel_house.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    public RoleDto toDto(Role role){
        if(role==null) {
            return null;
        }else {
            RoleDto dto = new RoleDto();
            dto.setName(role.getName());
            return dto;
        }
    }
    public Role toRole(RoleDto dto){
        if(dto==null) {
            return null;
        }else {

            Role r = new Role();

            r.setName(dto.getName());
            return r;

        }
    }
}

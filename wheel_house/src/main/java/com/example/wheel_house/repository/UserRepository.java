package com.example.wheel_house.repository;

import com.example.wheel_house.entity.Role;
import com.example.wheel_house.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

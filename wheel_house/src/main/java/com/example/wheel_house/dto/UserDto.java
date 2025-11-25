package com.example.wheel_house.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public class UserDto {
    @NotBlank(message = "userName must not be blank")
    private String userName;
    @NotBlank(message = "password must not be blank")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

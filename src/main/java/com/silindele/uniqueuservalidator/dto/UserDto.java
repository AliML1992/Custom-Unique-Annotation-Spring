package com.silindele.uniqueuservalidator.dto;

import com.silindele.uniqueuservalidator.validation.UniqueEmail;
import com.silindele.uniqueuservalidator.validation.UniqueUsername;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserDto {


    @NotEmpty
    @UniqueUsername
    private String username;

    @NotEmpty
    @UniqueEmail
    private String email;

    public UserDto() {
    }

    public UserDto(String username,String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

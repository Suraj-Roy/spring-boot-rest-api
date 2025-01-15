package com.example1.example1.dto;

import lombok.Data;

@Data
public class UserDto {

    private Long Id;
    
    private String name;

    private String email;

    private String password;

    private String address;
}

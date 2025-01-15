package com.example1.example1.service;

import java.util.List;

import com.example1.example1.dto.UserDto;

public interface UserService {

    public UserDto saveUser(UserDto userDto);

    public List<UserDto> getAllUsers();
    
    public UserDto updateUser(UserDto userDto);

    public boolean deleteUser(Long id);

    public UserDto getUserById(Long id);
    

}

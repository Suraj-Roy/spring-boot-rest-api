package com.example1.example1.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example1.example1.dto.UserDto;
import com.example1.example1.mapper.UserMapper;
import com.example1.example1.modal.User;
import com.example1.example1.repository.UserRepository;
import com.example1.example1.service.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public UserDto saveUser(UserDto userDto){
        User savedUser =  userRepository.save(userMapper.toUser(userDto));
        return userMapper.toUserDto(savedUser);
    }


    @Override
    public boolean deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            User curUser = user.get();
            userRepository.delete(curUser);
            return true;
        }

        return false;
    }


    @Override
    public List<UserDto> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers.stream().map(userMapper::toUserDto)
                        .collect(Collectors.toList());
    }


    @Override
    public UserDto updateUser(UserDto userDto) {
        User saedUser =  userRepository.save(userMapper.toUser(userDto));
        return userMapper.toUserDto(saedUser);
    }


    @Override
    public UserDto getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return userMapper.toUserDto(user.get());
        }
        return null;
    }

    
}

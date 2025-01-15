package com.example1.example1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example1.example1.dto.UserDto;
import com.example1.example1.service.UserService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@AllArgsConstructor
@RestController
public class UserController {

    private final UserService userService;
 
    

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody UserDto userDto) {
        if (ObjectUtils.isEmpty(userDto.getName()) || ObjectUtils.isEmpty(userDto.getEmail())
                        ||ObjectUtils.isEmpty(userDto.getPassword())) {
            return new ResponseEntity<>("Invalid user data", HttpStatus.BAD_REQUEST);
        }
        UserDto user = userService.saveUser(userDto);
        if (ObjectUtils.isEmpty(user)) {
            return new ResponseEntity<>("User not saved", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("User saved successfully", HttpStatus.CREATED);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getAllUsers() {
        List<UserDto> userDto = userService.getAllUsers();
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody UserDto userDto) {
        if (ObjectUtils.isEmpty(userDto.getId())) {
            return new ResponseEntity<>("User ID is required", HttpStatus.BAD_REQUEST);
        }
        UserDto updatedUser = userService.updateUser(userDto);
        if (ObjectUtils.isEmpty(updatedUser)) {
            return new ResponseEntity<>("User not updated", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        boolean isDeleted = userService.deleteUser(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }    

    @GetMapping("getUserById")
    public ResponseEntity<?> getMethodName(@RequestParam Long id) {
        UserDto user = userService.getUserById(id);
        if(ObjectUtils.isEmpty(user)){
            return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    

}

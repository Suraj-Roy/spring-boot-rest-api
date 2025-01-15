package com.example1.example1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example1.example1.modal.User;
public interface UserRepository extends JpaRepository<User, Long> {

}

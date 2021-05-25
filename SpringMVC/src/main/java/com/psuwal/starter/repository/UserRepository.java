package com.psuwal.starter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psuwal.starter.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}

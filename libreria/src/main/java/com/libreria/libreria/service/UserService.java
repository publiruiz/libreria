package com.libreria.libreria.service;

import com.libreria.libreria.persistencia.entity.User;
import com.libreria.libreria.persistencia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public List<User> getAllUser(){
        System.out.println("entra en service");

        return userRepository.getAllUser();
    }

    @Transactional
    public Optional<User> getUserById(Integer id){
        System.out.println("entra en service");
        return userRepository.getUserById(id);
    }

    @Transactional
    public void insertUser(User user){
         userRepository.insertUser(user);
    }

    @Transactional
    public void deleteUser(Integer id){
        System.out.println("Ha llegado al service");
         userRepository.delete(id);

    }



}

package com.libreria.libreria.controller;

import com.libreria.libreria.persistencia.entity.Book;
import com.libreria.libreria.persistencia.entity.User;
import com.libreria.libreria.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<User> getAllUser(){
        try{
            return userService.getAllUser();
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id")Integer id){
        try{
            System.out.println("entra en /id");
            return userService.getUserById(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public void deleteUser( @PathVariable("id")
                                        Integer id){
        try{
            System.out.println("Ha llegado al controller");
            userService.deleteUser(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }/*
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public void create( @RequestBody User user) {
        userService.insertUser(user);

    }*/

    @PostMapping("/new")
    public void addUser(@RequestBody User user){
        try{
             userService.insertUser(user);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


}




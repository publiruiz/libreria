package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import persistencia.entity.User;
import service.UserService;

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
            return userService.getUserById(id);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public User deleteUser( @PathVariable("id")
                                        Integer id){
        return userService.deleteUser(id);
    }

    @PostMapping("/new")
    public User addUser(@RequestBody User user){
        try{
            return userService.insertUser(user);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


}




package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import persistencia.entity.User;
import persistencia.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public List<User> getAllUser(){
        return userRepository.getAllUser();
    }

    @Transactional
    public Optional<User> getUserById(Integer id){
        return userRepository.getUserById(id);
    }

    @Transactional
    public User insertUser(User user){
        return userRepository.insertUser(user);
    }

    @Transactional
    public User deleteUser(Integer id){
        return userRepository.delete(id);
    }



}

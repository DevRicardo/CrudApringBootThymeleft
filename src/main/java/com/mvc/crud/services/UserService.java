package com.mvc.crud.services;

import java.util.List;
import java.util.Optional;

import com.mvc.crud.entities.User;
import com.mvc.crud.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User save(User user) {
        return this.userRepository.save(user);
    }

    public List<User> list() {
        return this.userRepository.findAll();
    }

    public void delete(User user) {
        this.userRepository.delete(user);
    }

    public Optional<User> get(Long id) {
        return this.userRepository.findById(id);
    }
}
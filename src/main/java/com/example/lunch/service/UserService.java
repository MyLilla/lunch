package com.example.lunch.service;

import com.example.lunch.model.User;
import com.example.lunch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getById(int id) {
        return userRepository.findById(id).orElseGet(null);
    }

    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return userRepository.save(user);
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public void update(User user) {
        Assert.notNull(user, "user must not be null");
        userRepository.save(user);
    }
}

package com.example.lunch.repository;

import com.example.lunch.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository <User, Integer> {

    @Modifying
    @Query("SELECT u FROM User u")
    public List<User> getAll();

}

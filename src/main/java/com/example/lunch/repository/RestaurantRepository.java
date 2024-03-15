package com.example.lunch.repository;

import com.example.lunch.model.Restaurant;
import org.springframework.data.repository.CrudRepository;


public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {

}

package com.example.lunch.service;

import com.example.lunch.model.Meal;
import com.example.lunch.repository.MealRepository;
import com.example.lunch.repository.RestaurantRepository;
import com.example.lunch.repository.UserRepository;
import com.example.lunch.util.AccessUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MealService {

    @Autowired
    MealRepository mealRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    public List<Meal> getAllMeals(int user_id, int restaurant_id) {
        if (userRepository.findById(user_id).get().isAdmin()) {
            return mealRepository.getMealsById(restaurant_id);
        } else {
            throw new AccessUserException("You are not admin");
        }
    }

    public List<Meal> getMealsWithDate(int user_id, int restaurant_id, LocalDate date) {
        if (userRepository.findById(user_id).get().isAdmin()) {
            return mealRepository.getMealsWithDate(restaurant_id, date);
        } else {
            throw new AccessUserException("You are not admin");
        }
    }

    public void deleteMeal(int user_id, Meal meal) {
        if (userRepository.findById(user_id).get().isAdmin()) {
            mealRepository.delete(meal);
        } else {
            throw new AccessUserException("You are not admin");
        }
    }

    public void addMeal(int user_id, int restaurant_id, Meal meal) {

        if (userRepository.findById(user_id).get().isAdmin()) {
            meal.setRestaurant(restaurantRepository.findById(restaurant_id).get());
            mealRepository.save(meal);
        } else {
            throw new AccessUserException("You are not admin");
        }
    }

    public void updateMealForToday(int user_id, int meal_id) {
        if (userRepository.findById(user_id).get().isAdmin()) {
            Meal updatedDateOfMeal = mealRepository.findById(meal_id).get();
            updatedDateOfMeal.setDate(LocalDate.now());
            mealRepository.save(updatedDateOfMeal);
        } else {
            throw new AccessUserException("You are not admin");
        }
    }
}

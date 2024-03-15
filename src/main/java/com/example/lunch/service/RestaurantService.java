package com.example.lunch.service;

import com.example.lunch.model.Restaurant;
import com.example.lunch.model.User;
import com.example.lunch.repository.RestaurantRepository;
import com.example.lunch.repository.UserRepository;
import com.example.lunch.util.AccessUserException;
import com.example.lunch.util.VoteTimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    UserRepository userRepository;

    public List<Restaurant> getAll() {
        return (List<Restaurant>) restaurantRepository.findAll();
    }

    public void addRestaurant(int user_id, Restaurant restaurant) {
        if (checkIsAdmin(user_id)) {
            restaurantRepository.save(restaurant);
        }
    }

    public void deleteRestaurant(int user_id, int restaurant_id) {
        if (checkIsAdmin(user_id)) {
            restaurantRepository.delete(restaurantRepository.findById(restaurant_id).get());
        }
    }

    public void vote(int user_id, int restaurant_id) {
        User user = userRepository.findById(user_id).get();
        LocalDateTime lastVote = user.getLastVoteDateTime();

        Restaurant restaurant = restaurantRepository.findById(restaurant_id).get();

        if ((lastVote.toLocalDate().isBefore(LocalDate.now())) ||
                (lastVote.toLocalDate().equals(LocalDate.now()) &&
                        lastVote.toLocalTime().isBefore(LocalTime.of(10, 59)))) {
            if (user.getLastVoteRestaurant() != restaurant_id && user.getLastVoteRestaurant() != 0) {
                Restaurant lastRestaurant = restaurantRepository.findById(user.getLastVoteRestaurant()).get();
                lastRestaurant.setRating(lastRestaurant.getRating() - 1);
                restaurantRepository.save(lastRestaurant);
            }
            user.setLastVoteRestaurant(restaurant_id);
            user.setLastVoteDateTime(LocalDateTime.now());
            userRepository.save(user);

            restaurant.setRating(restaurant.getRating() + 1);
            restaurantRepository.save(restaurant);
        } else {
            throw new VoteTimeException("You can't vote two times per day");
        }
    }

    private boolean checkIsAdmin(int user_id) {
        if (userRepository.findById(user_id).get().isAdmin()) {
            return true;
        } else {
            throw new AccessUserException("It's not possible to add restaurant. You are not admin");
        }
    }
}

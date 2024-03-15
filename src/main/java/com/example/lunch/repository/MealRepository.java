package com.example.lunch.repository;

import com.example.lunch.model.Meal;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MealRepository extends CrudRepository<Meal, Integer> {

    @Modifying
    @Query("from Meal m where m.date= :date and m.restaurant.id = :restaurantId")
    List<Meal> getMealForDay(@Param("date") LocalDate date,
                                  @Param("restaurantId") int restaurantId);

    @Modifying
    @Query("from Meal m where m.restaurant.id =?1")
    List<Meal> getMealsById(int Id);

    @Modifying
    @Query("from Meal m where m.restaurant.id =?1 and m.date =?2")
    List<Meal> getMealsWithDate(int id, LocalDate date);

}

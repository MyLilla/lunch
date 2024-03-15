package com.example.lunch.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "restaurant")
public class Restaurant extends AbstractBaseEntity {

    @Column(name = "name")
    @Size(min = 3, max = 15)
    private String name;

    @Column
    private int rating = 0;

    public Restaurant() {
    }

    public Restaurant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

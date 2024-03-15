package com.example.lunch.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "meal")
public class Meal extends AbstractBaseEntity {

    @Column(name = "name")
    @Size(min = 3, max = 15)
    private String name;

    @Column
    private double price;

    @Column
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY) // много объектов Meal могут ссылаться на один объект типа Restaurant
    @JoinColumn(name = "restaurant_id") // будет столбец restaurant_id который хранит id объекта Restaurant
    private Restaurant restaurant;

    public Meal() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", name=" + name +
                ", price='" + price + '\'' +
                ", restaurant=" + restaurant +
                ", date= " + date +
                '}';
    }
}

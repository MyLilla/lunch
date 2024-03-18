package com.example.lunch.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "meal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Meal extends AbstractBaseEntity {

    @Column(nullable = false, length = 20)
    @Size(min = 3, max = 20)
    private String name;

    @Column(nullable = false)
    private double price;

    @CreatedDate
    private LocalDate date;

    @Column(nullable = false)
    private boolean available = false;

    @ManyToOne(fetch = FetchType.LAZY) // много объектов Meal могут ссылаться на один объект типа Restaurant
    @JoinColumn(name = "restaurant_id") // будет столбец restaurant_id который хранит id объекта Restaurant
    private Restaurant restaurant;

}

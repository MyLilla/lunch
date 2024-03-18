package com.example.lunch.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "restaurant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Restaurant extends AbstractBaseEntity {

    @Column(name = "name", nullable = false, length = 20)
    @Size(min = 3, max = 20)
    private String name;

    @Column
    private int rating = 0;
}

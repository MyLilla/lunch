package com.example.lunch.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "password")
public class User extends AbstractBaseEntity {

    @Column(name = "name", nullable = false, length = 15)
    @NotBlank
    @Size(min = 5, max = 15)
    private String name;

    @Column(name = "email", nullable = false, unique = true, length = 15)
    @Email
    @NotBlank
    @Size(max = 15)
    private String email;

    @Column(name = "password", nullable = false, length = 15)
    @NotBlank
    @Size(min = 5, max = 15)
    private String password;

    @Column(name = "admin", nullable = false)
    private boolean isAdmin = false;

    @Column(name = "last_vote_date_time")
    private LocalDateTime lastVoteDateTime;

    @Column(name = "last_vote_restaurant")
    private Integer lastVoteRestaurant;

    public User(String name, String email, String password, boolean isAdmin) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }
}

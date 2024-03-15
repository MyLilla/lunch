package com.example.lunch.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "users")
public class User extends AbstractBaseEntity {

    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(min = 5, max = 20)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotBlank
    @Size(max = 128)
    private String email;

    @Column(name = "password", nullable = false)
    @NotBlank
    @Size(min = 5, max = 128)
    private String password;

    @Column(name = "admin", nullable = false)
    private boolean isAdmin = false;

    @Column(name = "last_vote_date_time")
    private LocalDateTime lastVoteDateTime;

    @Column(name = "last_vote_restaurant")
    private int lastVoteRestaurant;

    public User() {
    }

    public User(String name, String email, String password, boolean isAdmin) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public User(Integer id, String name, String email, String password, boolean isAdmin) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmin(boolean admin) {
        this.isAdmin = admin;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getLastVoteDateTime() {
        return lastVoteDateTime;
    }

    public void setLastVoteDateTime(LocalDateTime lastVote) {
        this.lastVoteDateTime = lastVote;
    }

    public int getLastVoteRestaurant() {
        return lastVoteRestaurant;
    }

    public void setLastVoteRestaurant(int lastVoteRestaurant) {
        this.lastVoteRestaurant = lastVoteRestaurant;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email=" + email +
                ", name=" + name +
                ", isAdmin=" + isAdmin +
                '}';
    }
}

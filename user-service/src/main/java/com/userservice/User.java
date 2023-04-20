package com.userservice;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.ToString;

/**
 * @author Dominik_Janiga
 */
@Entity
@Table(name = "users")
@ToString
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;

    @Column(name = "amount_of_posts")
    private int amountOfPosts;

    public User() {}

    public User(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAmountOfPosts() {
        return amountOfPosts;
    }

    public void setAmountOfPosts(int amountOfPosts) {
        this.amountOfPosts = amountOfPosts;
    }

    public UserResponseDto toResponseDto() {
        return new UserResponseDto(id, username, amountOfPosts);
    }

    void incrementNumberOfPosts() {
        ++amountOfPosts;
    }
}

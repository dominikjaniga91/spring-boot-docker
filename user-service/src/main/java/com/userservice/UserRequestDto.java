package com.userservice;

/**
 * @author Dominik_Janiga
 */
record UserRequestDto(String username) {

    User toUser() {
        return new User(username);
    }
}

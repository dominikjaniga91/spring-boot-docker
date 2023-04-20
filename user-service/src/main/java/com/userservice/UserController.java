package com.userservice;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dominik_Janiga
 */
@RestController
@RequestMapping("/users")
class UserController {

    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto) {
        return this.userService.createUser(userRequestDto);
    }

    @GetMapping("/{id}")
    UserResponseDto getUser(@PathVariable long id) {
        return this.userService.getUser(id);
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable long id) {
        this.userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    UserResponseDto updateUser(@PathVariable long id, @RequestBody UserRequestDto userRequestDto) {
        return this.userService.updateUser(id, userRequestDto);
    }
    
    @PostMapping("/amount-of-posts")
    void updateAmountOfPosts(@RequestBody Long userId) {
        this.userService.updateAmountOfPosts(userId);
    }
}

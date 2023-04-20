package com.userservice;

import org.springframework.stereotype.Service;

/**
 * @author Dominik_Janiga
 */
@Service
class UserService {

    private final UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    UserResponseDto createUser(UserRequestDto userRequestDto) {
        User userToSave = userRequestDto.toUser();
        User savedUser = this.userRepository.save(userToSave);
        return savedUser.toResponseDto();
    }

    UserResponseDto getUser(long userId) {
        User foundUser = this.userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        return foundUser.toResponseDto();
    }

    void deleteUser(long userId) {
        this.userRepository.deleteById(userId);
    }

    UserResponseDto updateUser(long userId, UserRequestDto userRequestDto) {
        User foundUser = this.userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        foundUser.setUsername(userRequestDto.username());
        return foundUser.toResponseDto();
    }

    public void updateAmountOfPosts(long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        user.incrementNumberOfPosts();
        this.userRepository.save(user);
    }
}

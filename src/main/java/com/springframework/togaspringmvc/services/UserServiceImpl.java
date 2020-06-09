package com.springframework.togaspringmvc.services;

import com.springframework.togaspringmvc.domain.User;
import com.springframework.togaspringmvc.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository ur) {
        this.userRepository = ur;
    }

    /**
     *
     * @param phoneNumber
     * @return User object from database
     */
    @Override
    public User findUserByPhoneNumber(String phoneNumber) {
        return userRepository.findById(phoneNumber).get();
    }

    /**
     *
     * @param user
     * @return User object after was saved in DB.
     */
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Tries to find the user if the DB, by phone number, if does not exist
     * will create a new one in repository.
     * @param newUser to get values from to update existing user
     * @param phoneNumber
     * @return updated User object
     */
    @Override
    public User updateUser(User newUser, String phoneNumber) {
        return userRepository.findById(phoneNumber)
                .map(user ->
                {
                    // after finding existing user, update him
                    user.setUsername(newUser.getUsername());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                            // did not find existing user, add to repository
                            return userRepository.save(newUser);
                        }

                );
    }

    /**
     * Deletes users from repository, by given phone number.
     * @param phoneNumber
     */
    @Override
    public void deleteUser(String phoneNumber) {
        userRepository.deleteById(phoneNumber);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

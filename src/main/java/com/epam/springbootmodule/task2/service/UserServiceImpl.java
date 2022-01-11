package com.epam.springbootmodule.task2.service;

import com.epam.springbootmodule.task2.exception.GlobalApplicationException;
import com.epam.springbootmodule.task2.exception.UserNotFoundException;
import com.epam.springbootmodule.task2.model.User;
import com.epam.springbootmodule.task2.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(long userId) {
        log.info("getting user by id  " + userId);

        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found by id " + userId));
    }

    @Override
    public User getUserByEmail(String email) {
        log.info("getting user by email " + email);

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found by email " + email));
    }

    @Override
    public User createUser(User user) {
        log.info("creating user:  " + user);

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            log.error("Email is not unique");
            throw new GlobalApplicationException("User with such email is already present");
        }

        return userRepository.save(user);
    }

    @Transactional
    @Override
    public User updateUser(User user) {
        log.info("updating user " + user);

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            log.error("Email is not unique");
            throw new GlobalApplicationException("User with such email is already present");
        }

        userRepository.findById(user.getId())
                .ifPresent(userById -> {
                            userById.setEmail(user.getEmail());
                            userById.setName(user.getName());
                        }
                );

        return user;
    }

    @Override
    public User deleteUser(long userId) {
        log.info("deleting user by id " + userId);

        Optional<User> userById = userRepository.findById(userId);
        if (userById.isPresent()) {
            userRepository.deleteById(userId);
        } else {
            throw new GlobalApplicationException("User updating error");
        }
        return userById.get();
    }

    public List<User> getAllUsers() {
        log.info("getting all users");
        return (List<User>) userRepository.findAll();
    }
}

package com.epam.springbootmodule.task2.controller;

import com.epam.springbootmodule.task2.dto.UserDto;
import com.epam.springbootmodule.task2.model.User;
import com.epam.springbootmodule.task2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/new")
    public ResponseEntity<HttpStatus> createUser(@RequestBody UserDto userDto) {
        userService.createUser(userDtoToUser(userDto));

        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<HttpStatus> updateUser(@RequestBody User user) {
        userService.updateUser(user);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        User userById = userService.getUserById(id);

        return ResponseEntity.ok(userById);
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        User userByEmail = userService.getUserByEmail(email);

        return ResponseEntity.ok(userByEmail);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable long id) {
        User deletedUser = userService.deleteUser(id);

        return ResponseEntity.ok(deletedUser);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> allUsers = userService.getAllUsers();

        return ResponseEntity.ok(allUsers);
    }

    private User userDtoToUser(UserDto userDto) {
        return new User(userDto.getName(), userDto.getEmail());
    }
}

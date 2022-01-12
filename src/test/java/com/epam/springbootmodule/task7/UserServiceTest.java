package com.epam.springbootmodule.task7;

import com.epam.springbootmodule.task7.model.User;
import com.epam.springbootmodule.task7.repo.UserRepository;
import com.epam.springbootmodule.task7.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Test
    void getUserByIdTest() {
        User user1 = new User("user1", "email1@gmail.com");
        long id = user1.getId();
        when(userRepository.findById(any(Long.class))).thenReturn(Optional.of(user1));

        assertNotNull(userService.getUserById(id));

        verify(userRepository, times(1)).findById(id);
    }

    @Test
    void getUserByEmailTest() {
        User user1 = new User("user1", "email1@gmail.com");
        String email = user1.getEmail();
        when(userRepository.findByEmail(any(String.class))).thenReturn(Optional.of(user1));

        assertNotNull(userService.getUserByEmail(email));

        verify(userRepository, times(1)).findByEmail(email);
    }

    @Test
    void createUserTest() {
        User user1 = new User("user1", "email1@gmail.com");
        when(userRepository.save(any(User.class))).thenReturn(user1);

        assertNotNull(userService.createUser(user1));

        verify(userRepository, times(1)).save(user1);
    }

    @Test
    void getAllUsersTest() {
        List<User> users = Arrays.asList(new User(), new User(), new User());
        when(userRepository.findAll()).thenReturn(users);

        assertEquals(3, userService.getAllUsers().size());

        verify(userRepository, times(1)).findAll();
    }

}

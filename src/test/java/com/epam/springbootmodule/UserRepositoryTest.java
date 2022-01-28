package com.epam.springbootmodule;

import com.epam.springbootmodule.model.User;
import com.epam.springbootmodule.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Profile;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void findByEmailTest() {
        User user1 = new User("user1", "email1@gmail.com");
        User user2 = new User("user2", "email2@test.com");
        User user3 = new User("user3", "email3@kaka.com");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        Optional<User> userByEmail = userRepository.findByEmail("email2@test.com");

        assertEquals("email2@test.com", userByEmail.get().getEmail());
    }
}

package com.epam.springbootmodule.task7;

import com.epam.springbootmodule.task7.controller.UserController;
import com.epam.springbootmodule.task7.model.User;
import com.epam.springbootmodule.task7.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserController.class)
@AutoConfigureMockMvc(addFilters = false)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Test
    public void getUserByIdTest() throws Exception {
        User user = new User(1L, "user1", "email1@gmail.com");
        userService.createUser(user);

        mvc.perform(get("/users/getById/{id}", user.getId()))
                .andExpect(status().is2xxSuccessful())
                .andReturn();
    }

    @Test
    public void createUserTest() throws Exception {
        User user = new User("userName", "email@mail.com");

        mvc.perform(post("/users/new")
                        .content(asJsonString(user))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void updateUserTest() throws Exception {
        User presentUser = new User(1L, "userName", "update@mail.com");
        userService.createUser(presentUser);

        User userForUpdate = new User("userName", "update_new@mail.com");

        mvc.perform(post("/users/update")
                        .content(asJsonString(userForUpdate))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getUserByEmailTest() throws Exception {
        User user = new User("userName", "getUserByEmail@mail.com");
        userService.createUser(user);

        mvc.perform(get("/users/getByEmail/{email}", user.getEmail()))
                .andExpect(status().is2xxSuccessful())
                .andReturn();
    }

    @Test
    public void getAllUsersTest() throws Exception {
        User user = new User("userName", "getAllUsers1@mail.com");
        User user2 = new User("userName", "getAllUsers2@mail.com");
        userService.createUser(user);
        userService.createUser(user2);

        mvc.perform(get("/users/all"))
                .andExpect(status().is2xxSuccessful())
                .andReturn();
    }

    @Test
    public void deleteUserTest() throws Exception {
        User user = new User("userName", "deleteUserTest@mail.com");
        userService.createUser(user);

        mvc.perform(delete("/users/delete/{id}", user.getId()))
                .andExpect(status().isOk())
                .andReturn();
    }

    public static String asJsonString(final User user) {
        try {
            return new ObjectMapper().writeValueAsString(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

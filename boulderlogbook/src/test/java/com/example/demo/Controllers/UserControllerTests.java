package com.example.demo.Controllers;

import com.example.demo.Security.JwtAuthFilter;
import com.example.demo.Services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc(addFilters = false)
class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private JwtAuthFilter jwtAuthFilter;

    @Test
    void getAllUsers_returnsOk() throws Exception {
        mockMvc.perform(get("/api/users"))
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void getUserById_nonExistingUser_returns404() throws Exception {
        mockMvc.perform(get("/api/users/999999"))
            .andExpect(status().isNotFound());
    }

    @Test
    void registerUser_createsUser() throws Exception {
        mockMvc.perform(post("/api/users/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                    {
                      "name": "Jan",
                      "email": "jan@test.com",
                      "password": "password"
                    }
                """))
            .andExpect(status().isOk());
    }

    @Test
    void getUserByName_nonExisting_returns404() throws Exception {
        mockMvc.perform(get("/api/users/name")
                .param("name", "BestaatNiet"))
            .andExpect(status().isNotFound());
    }

    @Test
    void getUserDto_nonExistingUser_returns404() throws Exception {
        mockMvc.perform(get("/api/users/999999/dto"))
            .andExpect(status().isNotFound());
    }
}

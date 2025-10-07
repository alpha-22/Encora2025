package com;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.controller.UserController;
import com.model.User;
import com.repository.UserRepository;

@WebMvcTest(UserController.class)
class UserControllerTest {
@Autowired
private MockMvc mockMvc;
@MockBean
private UserRepository userRepository;
@Test
void shouldReturnUser_whenExists() throws Exception {
when(userRepository.findById(1L)).thenReturn(Optional.of(new User(1L,"Alice")));
mockMvc.perform(get("/users/1"))
.andExpect(status().isOk())
.andExpect(jsonPath("$.name").value("Alice"));}}
package com.integrador.odonto.backendquintobimestre.controller;

import com.integrador.odonto.backendquintobimestre.entity.dto.UserDTO;
import com.integrador.odonto.backendquintobimestre.enums.UserRoles;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.integrador.odonto.backendquintobimestre.utils.ClinincaOdontologicaUtils.asJsonString;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void create() throws Exception{
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Narayana Brahmajyoti");
        userDTO.setUsername("brahmajyoti");
        userDTO.setEmail("brahma@email.com");
        userDTO.setPassword("123456789");
        userDTO.setUserRoles(UserRoles.ROLE_ADMIN);

        mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(asJsonString(userDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated());

    }

    @Test
    void createAuthenticationToken() throws Exception{
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("brahmajyoti");
        userDTO.setPassword("123456789");

        mockMvc.perform(MockMvcRequestBuilders.post("/user/authenticate")
                  .contentType(MediaType.APPLICATION_JSON)
                  .accept(MediaType.APPLICATION_JSON)
                  .content(asJsonString(userDTO)))
                  .andDo(MockMvcResultHandlers.print())
                  .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
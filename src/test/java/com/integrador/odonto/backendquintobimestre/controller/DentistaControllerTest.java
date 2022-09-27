package com.integrador.odonto.backendquintobimestre.controller;

import com.integrador.odonto.backendquintobimestre.entity.dto.DentistaDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.EnderecoDTO;
import com.integrador.odonto.backendquintobimestre.exception.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.integrador.odonto.backendquintobimestre.utils.ClinincaOdontologicaUtils.asJsonString;
import static com.integrador.odonto.backendquintobimestre.utils.ClinincaOdontologicaUtils.objectFromString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@SpringBootTest
@AutoConfigureMockMvc
class DentistaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    void init(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }
    @Test
    @WithMockUser(username = "Helena", password = "123456789", roles = "ADMIN")
    void create() throws Exception{
        DentistaDTO dentistaDTO = new DentistaDTO();
        dentistaDTO.setNome("Helena");
        dentistaDTO.setSobreNome("Melo de Campos");
        dentistaDTO.setMatricula("CD-12785");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/dentista/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(dentistaDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();
        responseBody = mvcResult.getResponse().getContentAsString();


        dentistaDTO = objectFromString(DentistaDTO.class, responseBody);
        assertNotNull(dentistaDTO.getId());
        assertNotEquals("Gabi", dentistaDTO.getNome());
        assertEquals("Helena", dentistaDTO.getNome());
        assertEquals("Melo de Campos", dentistaDTO.getSobreNome());
        assertEquals(1,dentistaDTO.getId());
        //assertThrows();
    }

    @Test
    @WithMockUser(username = "Helena", password = "123456789", roles = "ADMIN")
    void getById() throws Exception{
        DentistaDTO dentistaDTO = new DentistaDTO();
        dentistaDTO.setNome("Helena");
        dentistaDTO.setSobreNome("Melo de Campos");
        dentistaDTO.setMatricula("CD-12785");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/dentista/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(dentistaDTO)))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();

        dentistaDTO = objectFromString(DentistaDTO.class, responseBody);

        mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/dentista/getById/{id}", dentistaDTO.getId())
                        .accept(MediaType.APPLICATION_JSON))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();

        responseBody = mvcResult.getResponse().getContentAsString();
        DentistaDTO dentistaDTO2 = objectFromString(DentistaDTO.class, responseBody);
        dentistaDTO = objectFromString(DentistaDTO.class, responseBody);

        assertNotNull(dentistaDTO.getId());
        assertEquals(dentistaDTO.getId(), dentistaDTO2.getId());
        assertEquals(1,dentistaDTO.getId());
        assertEquals("CD-12785", dentistaDTO2.getMatricula());

    }

    @Test
    @WithMockUser(username = "Helena", password = "123456789", roles = "ADMIN")
    void update() throws Exception{
    }

    @Test
    @WithMockUser(username = "Helena", password = "123456789", roles = "ADMIN")
    void getAll() throws  Exception{
    }

    @Test
    @WithMockUser(username = "Helena", password = "123456789", roles = "ADMIN")
    void delete() throws Exception{
    }
}
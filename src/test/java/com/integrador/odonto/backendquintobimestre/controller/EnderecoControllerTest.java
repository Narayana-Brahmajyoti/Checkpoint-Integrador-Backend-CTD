package com.integrador.odonto.backendquintobimestre.controller;

import com.integrador.odonto.backendquintobimestre.entity.dto.EnderecoDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
import com.integrador.odonto.backendquintobimestre.exception.NotFoundException;

import org.json.JSONArray;
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

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static com.integrador.odonto.backendquintobimestre.utils.ClinincaOdontologicaUtils.asJsonString;
import static com.integrador.odonto.backendquintobimestre.utils.ClinincaOdontologicaUtils.objectFromString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@SpringBootTest
@AutoConfigureMockMvc
class EnderecoControllerTest {

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
    @WithMockUser(username = "narayana", password = "123456789", roles = "ADMIN")
    void create() throws Exception{
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setRua("Rodolfo Dantas");
        enderecoDTO.setNumero("101");
        enderecoDTO.setComplemento("Apto 208");
        enderecoDTO.setBairro("Copacabana");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/endereco/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(enderecoDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();

        enderecoDTO = objectFromString(EnderecoDTO.class, responseBody);
        assertNotNull(enderecoDTO.getId());
        assertEquals("Rodolfo Dantas", enderecoDTO.getRua());

    }

    @Test
    @WithMockUser(username = "narayana", password = "123456789", roles = "ADMIN")
    void getById() throws Exception {
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setRua("Rodolfo Dantas");
        enderecoDTO.setNumero("101");
        enderecoDTO.setComplemento("Apto 208");
        enderecoDTO.setBairro("Copacabana");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/endereco/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(enderecoDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();

        enderecoDTO = objectFromString(EnderecoDTO.class, responseBody);

        mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/endereco/getById/{id}", enderecoDTO.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        responseBody = mvcResult.getResponse().getContentAsString();
        EnderecoDTO enderecoDTO2 = objectFromString(EnderecoDTO.class, responseBody);

        assertNotNull(enderecoDTO.getId(), String.valueOf(enderecoDTO2.getId()));
        assertEquals(enderecoDTO.getId(), enderecoDTO2.getId());
        assertEquals(enderecoDTO.getRua(), enderecoDTO2.getRua());

    }

    @Test
    @WithMockUser(username = "narayana", password = "123456789", roles = "ADMIN")
    void getAll() throws Exception{
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setRua("Rodolfo Dantas");
        enderecoDTO.setNumero("101");
        enderecoDTO.setComplemento("Apto 208");
        enderecoDTO.setBairro("Copacabana");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/endereco/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(enderecoDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();

        enderecoDTO = objectFromString(EnderecoDTO.class, responseBody);

        mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/endereco/getAll")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        responseBody = mvcResult.getResponse().getContentAsString();
        System.out.println(responseBody);
        JSONArray jsonArray = new JSONArray(responseBody);
        List<String> list = new ArrayList<String>();
        for (int i=0; i<jsonArray.length(); i++)
            list.add( jsonArray.getString(i) );
        assertTrue(list.size() > 0);
    }

    @Test
    @WithMockUser(username = "narayana", password = "123456789", roles = "ADMIN")
    void delete() throws Exception{
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setRua("Rodolfo Dantas");
        enderecoDTO.setNumero("101");
        enderecoDTO.setComplemento("Apto 208");
        enderecoDTO.setBairro("Copacabana");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/endereco/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(enderecoDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();

        enderecoDTO = objectFromString(EnderecoDTO.class, responseBody);

        mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/endereco/delete/{id}", enderecoDTO.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        
        mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/endereco/getById/{id}", enderecoDTO.getId())
                .accept(MediaType.APPLICATION_JSON))
        		.andDo(MockMvcResultHandlers.print())
        		.andExpect(MockMvcResultMatchers.status().is4xxClientError())
        		.andReturn();
    }

    @Test
    @WithMockUser(username = "narayana", password = "123456789", roles = "ADMIN")
    void update() throws Exception{
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setRua("Rodolfo Dantas");
        enderecoDTO.setNumero("101");
        enderecoDTO.setComplemento("Apto 208");
        enderecoDTO.setBairro("Copacabana");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/endereco/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(enderecoDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();

        enderecoDTO = objectFromString(EnderecoDTO.class, responseBody);
        
        enderecoDTO.setRua("Rodolfo Dantas updated");
        
        mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/endereco/update/{id}", enderecoDTO.getId())
                	.contentType(MediaType.APPLICATION_JSON)
                	.accept(MediaType.APPLICATION_JSON)
                	.content(asJsonString(enderecoDTO)))
        			.andDo(MockMvcResultHandlers.print())
        			.andExpect(MockMvcResultMatchers.status().isOk())
        			.andReturn();
        
        responseBody = mvcResult.getResponse().getContentAsString();

        enderecoDTO = objectFromString(EnderecoDTO.class, responseBody);
        assertEquals("Rodolfo Dantas updated", enderecoDTO.getRua());
    }
}
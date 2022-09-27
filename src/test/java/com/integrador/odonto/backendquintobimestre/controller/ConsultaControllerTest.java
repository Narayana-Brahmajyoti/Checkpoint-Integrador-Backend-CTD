package com.integrador.odonto.backendquintobimestre.controller;

import com.integrador.odonto.backendquintobimestre.entity.dto.ConsultaDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.DentistaDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.EnderecoDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
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

import java.time.LocalDateTime;

import static com.integrador.odonto.backendquintobimestre.utils.ClinincaOdontologicaUtils.asJsonString;
import static com.integrador.odonto.backendquintobimestre.utils.ClinincaOdontologicaUtils.objectFromString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@SpringBootTest
@AutoConfigureMockMvc
class ConsultaControllerTest {
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
        int idEndereco;
        enderecoDTO.setRua("Rua Rio Negro");
        enderecoDTO.setNumero("1234");
        enderecoDTO.setComplemento("apto 1104");
        enderecoDTO.setBairro("Vera Cruz");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/endereco/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(enderecoDTO)))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();
        responseBody = mvcResult.getResponse().getContentAsString();

        enderecoDTO = objectFromString(EnderecoDTO.class, responseBody);

        PacienteDTO pacienteDTO = new PacienteDTO();
        int idPaciente;
        pacienteDTO.setNome("Gabriela");
        pacienteDTO.setSobreNome("Carvalho");
        pacienteDTO.setEndereco(enderecoDTO);
        pacienteDTO.setRg("MG-15678");
        pacienteDTO.setDataDeAlta("25/10/2022");

        mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/paciente/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(pacienteDTO)))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();

        responseBody = mvcResult.getResponse().getContentAsString();
        responseBody = mvcResult.getResponse().getContentAsString();

        pacienteDTO = objectFromString(PacienteDTO.class, responseBody);

        DentistaDTO dentistaDTO = new DentistaDTO();
        int idDentista;
        dentistaDTO.setNome("Helena");
        dentistaDTO.setSobreNome("Melo de Campos");
        dentistaDTO.setMatricula("CD-12785");

        mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/dentista/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(dentistaDTO)))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();

        responseBody = mvcResult.getResponse().getContentAsString();
        responseBody = mvcResult.getResponse().getContentAsString();

        dentistaDTO = objectFromString(DentistaDTO.class, responseBody);

        ConsultaDTO consultaDTO = new ConsultaDTO();
//        int IdConsulta;
        consultaDTO.setPaciente(pacienteDTO);
        consultaDTO.setDentista(dentistaDTO);
        consultaDTO.setDataHoraConsulta(LocalDateTime.of(2022,3,11,10, 25, 30));

        mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/consulta/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(consultaDTO)))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();

//        responseBody = mvcResult.getResponse().getContentAsString();
        responseBody = mvcResult.getResponse().getContentAsString();

        consultaDTO = objectFromString(ConsultaDTO.class, responseBody);

        assertNotNull(consultaDTO.getId());
//        assertNotEquals("Gabi", pacienteDTO.getNome());
//        assertEquals("Gabriela", pacienteDTO.getNome());
//        assertEquals("Carvalho", pacienteDTO.getSobreNome());
//        assertEquals(1,pacienteDTO.getId());
//        assertNotNull(enderecoDTO);
//        assertEquals("Rua Rio Negro", enderecoDTO.getRua());
    }

    @Test
    @WithMockUser(username = "narayana", password = "123456789", roles = "ADMIN")
    void getById() throws Exception {
    }

    @Test
    @WithMockUser(username = "narayana", password = "123456789", roles = "ADMIN")
    void getAll() throws Exception {
    }

    @Test
    @WithMockUser(username = "narayana", password = "123456789", roles = "ADMIN")
    void delete() throws Exception{
    }

    @Test
    @WithMockUser(username = "narayana", password = "123456789", roles = "ADMIN")
    void update() throws Exception{
    }

    @Test
    @WithMockUser(username = "narayana", password = "123456789", roles = "ADMIN")
    void getByPaciente() {
    }
}
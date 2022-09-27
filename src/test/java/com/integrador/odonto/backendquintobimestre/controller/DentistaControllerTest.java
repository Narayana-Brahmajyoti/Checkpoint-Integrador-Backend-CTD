package com.integrador.odonto.backendquintobimestre.controller;

import com.integrador.odonto.backendquintobimestre.entity.dto.DentistaDTO;
<<<<<<< HEAD
=======
import com.integrador.odonto.backendquintobimestre.entity.dto.EnderecoDTO;
import com.integrador.odonto.backendquintobimestre.exception.NotFoundException;
>>>>>>> devel
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
<<<<<<< HEAD
        mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
    }

    @Test
    @WithMockUser(username = "narayana", password = "123456789", roles = "ADMIN")
    void create() throws Exception{
        DentistaDTO dentistaDTO = new DentistaDTO();
        dentistaDTO.setNome("Fulano");
        dentistaDTO.setSobreNome("Sicrano");
        dentistaDTO.setMatricula("12548");


        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/dentista/create").contentType(MediaType.APPLICATION_JSON)
=======
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
>>>>>>> devel
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(dentistaDTO)))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();

        dentistaDTO = objectFromString(DentistaDTO.class, responseBody);

<<<<<<< HEAD
        assertNotNull(dentistaDTO.getId());

    }

    @Test
    @WithMockUser(username = "narayana", password = "123456789", roles = "ADMIN")
    void getById() throws Exception{
        DentistaDTO dentistaDTO = new DentistaDTO();
        dentistaDTO.setNome("Bixim");
        dentistaDTO.setSobreNome("Fofim");
        dentistaDTO.setMatricula("00001");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/dentista/create").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(dentistaDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();

        dentistaDTO = objectFromString(DentistaDTO.class, responseBody);

        //assertNotNull(dentistaDTO.getId());

         mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/dentista/getById/{id}", dentistaDTO.getId()).accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        responseBody = mvcResult.getResponse().getContentAsString();

        DentistaDTO dentistaDTO2 = objectFromString(DentistaDTO.class, responseBody);

        assertEquals(dentistaDTO.getId(), dentistaDTO2.getId());
        assertEquals(dentistaDTO.getNome(), dentistaDTO2.getNome());

    }


    @Test
    @WithMockUser(username = "narayana", password = "123456789", roles = "ADMIN")
    void getAll() throws Exception{
        DentistaDTO dentistaDTO = new DentistaDTO();
        dentistaDTO.setNome("XPTO");
        dentistaDTO.setSobreNome("XP");
        dentistaDTO.setMatricula("021547");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/dentista/create").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(dentistaDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();

        dentistaDTO = objectFromString(DentistaDTO.class, responseBody);


        mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/dentista/getAll").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        responseBody = mvcResult.getResponse().getContentAsString();

        assertNotNull(dentistaDTO);
=======
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
>>>>>>> devel

    }

    @Test
<<<<<<< HEAD
    @WithMockUser(username = "narayana", password = "123456789", roles = "ADMIN")
    void delete() throws Exception{
        DentistaDTO dentistaDTO = new DentistaDTO();
        dentistaDTO.setNome("Fulano");
        /*dentistaDTO.setSobreNome("Sicrano");
        dentistaDTO.setMatricula("12548");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/dentista/create").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(dentistaDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();*/

        dentistaDTO = objectFromString(DentistaDTO.class, responseBody);


        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/dentista/delete/{id}", dentistaDTO.getId()).accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();

        assertEquals(dentistaDTO.getId(), dentistaDTO.getId());

    }


=======
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
>>>>>>> devel
}
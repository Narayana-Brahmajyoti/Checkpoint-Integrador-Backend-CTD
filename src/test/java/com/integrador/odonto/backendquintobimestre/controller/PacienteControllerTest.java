package com.integrador.odonto.backendquintobimestre.controller;

import com.integrador.odonto.backendquintobimestre.entity.dto.DentistaDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.EnderecoDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
import com.integrador.odonto.backendquintobimestre.service.impl.EnderecoServiceImpl;
import com.integrador.odonto.backendquintobimestre.service.impl.PacienteServiceImpl;
import org.junit.jupiter.api.Assertions;
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

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

@SpringBootTest
@AutoConfigureMockMvc
class PacienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;


    @BeforeEach
    void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithMockUser(username = "narayana", password = "123456789", roles = "ADMIN")
    void create() throws Exception{
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        String rua = "Rua Rio Negro";
        String numero = "1234";
        String complemento = "apto 1104";
        String bairro = "Vera Cruz";

        enderecoDTO.setRua(rua);
        enderecoDTO.setNumero(numero);
        enderecoDTO.setComplemento(complemento);
        enderecoDTO.setBairro(bairro);

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
        String nome = "Gabriela";
        String sobreNome = "Carvalho";
        String rg = "MG-15678";
        String dataDeAlta = "25/10/2022";


        pacienteDTO.setNome(nome);
        pacienteDTO.setSobreNome(sobreNome);
        pacienteDTO.setEndereco(enderecoDTO);
        pacienteDTO.setRg(rg);
        pacienteDTO.setDataDeAlta(dataDeAlta);

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

        assertNotNull(pacienteDTO.getId());
        assertNotEquals("Gabi", pacienteDTO.getNome());
        assertEquals("Gabriela", pacienteDTO.getNome());
        assertEquals("Carvalho", pacienteDTO.getSobreNome());
        assertNotNull(enderecoDTO);
        assertEquals("Rua Rio Negro", enderecoDTO.getRua());
    }

    @Test
    @WithMockUser(username = "narayana", password = "123456789", roles = "ADMIN")
    void getById() throws Exception{
        EnderecoDTO enderecoDTO = new EnderecoDTO();
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

        mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/paciente/getById/{id}", pacienteDTO.getId())
                        .accept(MediaType.APPLICATION_JSON))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();

        responseBody = mvcResult.getResponse().getContentAsString();
        PacienteDTO pacienteDTO2 = objectFromString(PacienteDTO.class, responseBody);
        pacienteDTO = objectFromString(PacienteDTO.class, responseBody);

        assertNotNull(pacienteDTO.getId());
        assertEquals(pacienteDTO.getId(), pacienteDTO2.getId());
        assertNotEquals(1,pacienteDTO.getId());
        assertNotEquals("Gabi", pacienteDTO.getNome());
        assertEquals("Gabriela", pacienteDTO.getNome());
        assertEquals("Carvalho", pacienteDTO.getSobreNome());
        assertNotNull(enderecoDTO);
        assertEquals("Rua Rio Negro", enderecoDTO.getRua());
    }

    @Test
    @WithMockUser(username = "narayana", password = "123456789", roles = "ADMIN")
    void getAll() throws Exception{
        EnderecoDTO enderecoDTO = new EnderecoDTO();
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

        pacienteDTO = objectFromString(PacienteDTO.class, responseBody);
        
        mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/paciente/getAll")
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

        pacienteDTO = objectFromString(PacienteDTO.class, responseBody);
        
        mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/paciente/delete/{id}", pacienteDTO.getId())
		                .accept(MediaType.APPLICATION_JSON))
				        .andDo(MockMvcResultHandlers.print())
				        .andExpect(MockMvcResultMatchers.status().isOk())
				        .andReturn();

		mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/paciente/getById/{id}", pacienteDTO.getId())
				        .accept(MediaType.APPLICATION_JSON))
						.andDo(MockMvcResultHandlers.print())
						.andExpect(MockMvcResultMatchers.status().is4xxClientError())
						.andReturn();
    }

    @Test
    @WithMockUser(username = "narayana", password = "123456789", roles = "ADMIN")
    void update() throws Exception{
        EnderecoDTO enderecoDTO = new EnderecoDTO();
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

        pacienteDTO = objectFromString(PacienteDTO.class, responseBody);
        
        pacienteDTO.setNome("Updated");
        
        mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/paciente/update/{id}", pacienteDTO.getId())
		            	.contentType(MediaType.APPLICATION_JSON)
		            	.accept(MediaType.APPLICATION_JSON)
		            	.content(asJsonString(pacienteDTO)))
		    			.andDo(MockMvcResultHandlers.print())
		    			.andExpect(MockMvcResultMatchers.status().isOk())
		    			.andReturn();
    
	    responseBody = mvcResult.getResponse().getContentAsString();
	
	    pacienteDTO = objectFromString(PacienteDTO.class, responseBody);
	    
        mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/paciente/getById/{id}", pacienteDTO.getId())
		                .accept(MediaType.APPLICATION_JSON))
		                .andDo(MockMvcResultHandlers.print())
		                .andExpect(MockMvcResultMatchers.status().isOk())
		                .andReturn();

		responseBody = mvcResult.getResponse().getContentAsString();
		PacienteDTO pacienteDTO2 = objectFromString(PacienteDTO.class, responseBody);
		assertEquals(pacienteDTO2.getNome(), "Updated");
    }

    @Test
    @WithMockUser(username = "narayana", password = "123456789", roles = "ADMIN")
    void getByName() throws Exception{
        EnderecoDTO enderecoDTO = new EnderecoDTO();
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

        pacienteDTO = objectFromString(PacienteDTO.class, responseBody);
        
        mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/paciente/getByName")
		                .accept(MediaType.APPLICATION_JSON)
		        		.param("nome", "Gabriela"))
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
    void getBySurname() throws Exception{
        EnderecoDTO enderecoDTO = new EnderecoDTO();
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

        pacienteDTO = objectFromString(PacienteDTO.class, responseBody);
        
        mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/paciente/getBySurname")
		                .accept(MediaType.APPLICATION_JSON)
		        		.param("sobrenome", "Carvalho"))
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
    void getByRg() throws Exception{
        EnderecoDTO enderecoDTO = new EnderecoDTO();
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

        pacienteDTO = objectFromString(PacienteDTO.class, responseBody);
        
        mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/paciente/getByRg")
		                .accept(MediaType.APPLICATION_JSON)
		        		.param("rg", "MG-15678"))
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
    void getByDataDeAlta() throws Exception{
        EnderecoDTO enderecoDTO = new EnderecoDTO();
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

        pacienteDTO = objectFromString(PacienteDTO.class, responseBody);
        
        mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/paciente/getByDataDeAlta")
		                .accept(MediaType.APPLICATION_JSON)
		        		.param("dataDeAlta", "25/10/2022"))
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
}
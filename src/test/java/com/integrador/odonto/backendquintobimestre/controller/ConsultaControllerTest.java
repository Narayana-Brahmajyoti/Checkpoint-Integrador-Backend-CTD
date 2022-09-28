package com.integrador.odonto.backendquintobimestre.controller;

import com.integrador.odonto.backendquintobimestre.entity.dto.ConsultaDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.DentistaDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.EnderecoDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
        dentistaDTO.setMatricula("CD-7897654");

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
        Integer IdConsulta;
        consultaDTO.setPaciente(pacienteDTO);
        consultaDTO.setDentista(dentistaDTO);
        consultaDTO.setDataHoraConsulta(LocalDateTime.now());

        mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/consulta/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(consultaDTO)))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();


        responseBody = mvcResult.getResponse().getContentAsString();

        consultaDTO = objectFromString(ConsultaDTO.class, responseBody);

        assertNotNull(consultaDTO.getId());


        assertNotEquals("Gabi", pacienteDTO.getNome());
        assertEquals("Gabriela", pacienteDTO.getNome());
        assertEquals("Carvalho", pacienteDTO.getSobreNome());
        assertNotNull(enderecoDTO);
        assertEquals("Rua Rio Negro", enderecoDTO.getRua());
    }

    @Test
    @WithMockUser(username = "narayana", password = "123456789", roles = "ADMIN")
    void getById() throws Exception {
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

        pacienteDTO = objectFromString(PacienteDTO.class, responseBody);

        DentistaDTO dentistaDTO = new DentistaDTO();
        int idDentista;
        dentistaDTO.setNome("Helena");
        dentistaDTO.setSobreNome("Melo de Campos");
        dentistaDTO.setMatricula("CD-157646");

        mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/dentista/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(dentistaDTO)))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();

        responseBody = mvcResult.getResponse().getContentAsString();

        dentistaDTO = objectFromString(DentistaDTO.class, responseBody);

        ConsultaDTO consultaDTO = new ConsultaDTO();
        Integer IdConsulta;
        consultaDTO.setPaciente(pacienteDTO);
        consultaDTO.setDentista(dentistaDTO);
        consultaDTO.setDataHoraConsulta(LocalDateTime.of(2022,4,26,10, 25, 30));

        /*mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/consulta/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(consultaDTO)))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();


        responseBody = mvcResult.getResponse().getContentAsString();

        consultaDTO = objectFromString(ConsultaDTO.class, responseBody);

        mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/consulta/getById/{id}", consultaDTO.getId() )
                        .accept(MediaType.APPLICATION_JSON))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();

        responseBody = mvcResult.getResponse().getContentAsString();
        ConsultaDTO consultaDTO1 = objectFromString(ConsultaDTO.class, responseBody);
        consultaDTO = objectFromString(ConsultaDTO.class, responseBody);


        assertNotNull(consultaDTO.getId());
        assertEquals(consultaDTO.getId(), consultaDTO1.getId());
        assertNotEquals("Gabi", consultaDTO.getPaciente().getNome());
        assertEquals("Gabriela", consultaDTO.getPaciente().getNome());
        assertEquals("Helena", consultaDTO.getDentista().getNome());*/

    }

    @Test
    @WithMockUser(username = "narayana", password = "123456789", roles = "ADMIN")
    void getAll() throws Exception {
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

        pacienteDTO = objectFromString(PacienteDTO.class, responseBody);

        DentistaDTO dentistaDTO = new DentistaDTO();
        int idDentista;
        dentistaDTO.setNome("Helena");
        dentistaDTO.setSobreNome("Melo de Campos");
        dentistaDTO.setMatricula("OP-4897");

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
        Integer IdConsulta;
        consultaDTO.setPaciente(pacienteDTO);
        consultaDTO.setDentista(dentistaDTO);
        consultaDTO.setDataHoraConsulta(LocalDateTime.of(2022,3,15,10, 28, 30));

        mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/consulta/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(consultaDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();


        responseBody = mvcResult.getResponse().getContentAsString();

        consultaDTO = objectFromString(ConsultaDTO.class, responseBody);

        mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/consulta/getAll")
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

        pacienteDTO = objectFromString(PacienteDTO.class, responseBody);

        DentistaDTO dentistaDTO = new DentistaDTO();
        int idDentista;
        dentistaDTO.setNome("Helena");
        dentistaDTO.setSobreNome("Melo de Campos");
        dentistaDTO.setMatricula("OP-1256841");

        mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/dentista/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(dentistaDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        responseBody = mvcResult.getResponse().getContentAsString();

        dentistaDTO = objectFromString(DentistaDTO.class, responseBody);

        ConsultaDTO consultaDTO = new ConsultaDTO();
        Integer IdConsulta;
        consultaDTO.setPaciente(pacienteDTO);
        consultaDTO.setDentista(dentistaDTO);
        consultaDTO.setDataHoraConsulta(LocalDateTime.of(2022,3,5,11, 30));

        mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/consulta/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(consultaDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();


        responseBody = mvcResult.getResponse().getContentAsString();

        consultaDTO = objectFromString(ConsultaDTO.class, responseBody);

        mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/consulta/delete/{id}", consultaDTO.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/consulta/getById/{id}", consultaDTO.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andReturn();
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

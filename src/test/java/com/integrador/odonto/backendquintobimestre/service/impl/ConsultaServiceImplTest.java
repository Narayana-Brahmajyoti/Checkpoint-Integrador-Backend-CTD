package com.integrador.odonto.backendquintobimestre.service.impl;

import com.integrador.odonto.backendquintobimestre.entity.dto.DentistaDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.EnderecoDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class ConsultaServiceImplTest {

    @Autowired
    private ConsultaServiceImpl consultaService;

    @Autowired
    private DentistaServiceImpl dentistaService;

    @Autowired
    private PacienteServiceImpl pacienteService;

    @Autowired
            EnderecoServiceImpl enderecoService;

    @BeforeEach
    public void doBefore() {

        int idConsulta;

        EnderecoDTO enderecoDTO = new EnderecoDTO();
        int idEndereco;
        String rua = "Rua Rio Negro";
        String numero = "1234";
        String complemento = "apto 1104";
        String bairro = "Vera Cruz";

        enderecoDTO.setRua(rua);
        enderecoDTO.setNumero(numero);
        enderecoDTO.setComplemento(complemento);
        enderecoDTO.setBairro(bairro);

        PacienteDTO pacienteDTO = new PacienteDTO();
        int idPaciente;
        String nomePaciente = "Gabriela";
        String sobreNomePaciente = "Carvalho";
        String rg = "MG-15678";
        String dataDeAlta = "25/10/2022";

        pacienteDTO.setNome(nomePaciente);
        pacienteDTO.setSobreNome(sobreNomePaciente);
        pacienteDTO.setEndereco(enderecoDTO);
        pacienteDTO.setRg(rg);
        pacienteDTO.setDataDeAlta(dataDeAlta);

        DentistaDTO dentistaDTO = new DentistaDTO();
        int idDentista;
        String nomeDentista = "Raquel";
        String sobreNomeDentista = "Fernandes";
        String matriculaDentista = "CD-15498";

        dentistaDTO.setNome(nomeDentista);
        dentistaDTO.setSobreNome(sobreNomeDentista);
        dentistaDTO.setMatricula(matriculaDentista);

        //Calendar dataHoraConsulta = 2022-04-14T11:46:21.448769400;
    }


    @Test
    @Order(1)
    void create() {





    }

    @Test
    @Order(2)
    void getById() {
    }

    @Test
    @Order(3)
    void getAll() {
    }

    @Test
    @Order(4)
    void delete() {
    }

    @Test
    @Order(5)
    void update() {
    }

    @Test
    @Order(6)
    void ifConsultaExists() {
    }

    @Test
    @Order(7)
    void getByPaciente() {
    }
}
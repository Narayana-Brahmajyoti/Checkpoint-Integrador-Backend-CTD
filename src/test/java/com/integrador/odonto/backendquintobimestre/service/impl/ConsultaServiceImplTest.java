package com.integrador.odonto.backendquintobimestre.service.impl;

import com.integrador.odonto.backendquintobimestre.entity.dto.ConsultaDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.DentistaDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.EnderecoDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
import com.integrador.odonto.backendquintobimestre.exception.NotFoundException;
import com.integrador.odonto.backendquintobimestre.exception.UniqueIndexException;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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


    @Test
    @Order(1)
    void create() {
        int idConsulta;

        EnderecoDTO endereco = new EnderecoDTO();
            int idEndereco;
            String rua = "Rua Rio Negro";
            String numero = "1234";
            String complemento = "apto 1104";
            String bairro = "Vera Cruz";


            endereco.setRua(rua);
            endereco.setNumero(numero);
            endereco.setComplemento(complemento);
            endereco.setBairro(bairro);

        PacienteDTO paciente = new PacienteDTO();
            int idPaciente;
            String nomePaciente = "Gabriela";
            String sobreNomePaciente = "Carvalho";
            String rg = "MG-15678";
            String dataDeAlta = "25/10/2022";


            paciente.setNome(nomePaciente);
            paciente.setSobreNome(sobreNomePaciente);
            paciente.setEndereco(endereco);
            paciente.setRg(rg);
            paciente.setDataDeAlta(dataDeAlta);

        DentistaDTO dentista = new DentistaDTO();
            int idDentista;
            String nomeDentista = "Raquel";
            String sobreNomeDentista = "Fernandes";
            String matriculaDentista = "CD-15498";

            dentista.setNome(nomeDentista);
            dentista.setSobreNome(sobreNomeDentista);
            dentista.setMatricula(matriculaDentista);

        ConsultaDTO consulta = new ConsultaDTO();
        LocalDateTime dataHoraConsulta = LocalDateTime.of(2022,3,28,10, 25, 30);
            consulta.setPaciente(paciente);
            consulta.setDentista(dentista);
            consulta.setDataHoraConsulta(dataHoraConsulta);

            assertTrue(consulta.getPaciente().equals(paciente));
            assertTrue(consulta.getDentista().equals(dentista));
            assertTrue(consulta.getDataHoraConsulta().equals(dataHoraConsulta));

    }

    @Test
    @Order(2)
    void getById() throws NotFoundException, UniqueIndexException {
//        int idConsulta;
//
//        EnderecoDTO endereco = new EnderecoDTO();
//        int idEndereco;
//        String rua = "Rua Rio Negro";
//        String numero = "1234";
//        String complemento = "apto 1104";
//        String bairro = "Vera Cruz";
//
//
//        endereco.setRua(rua);
//        endereco.setNumero(numero);
//        endereco.setComplemento(complemento);
//        endereco.setBairro(bairro);
//
//        PacienteDTO paciente = new PacienteDTO();
//        int idPaciente;
//        String nomePaciente = "Gabriela";
//        String sobreNomePaciente = "Carvalho";
//        String rg = "MG-15678";
//        String dataDeAlta = "25/10/2022";
//
//
//        paciente.setNome(nomePaciente);
//        paciente.setSobreNome(sobreNomePaciente);
//        paciente.setEndereco(endereco);
//        paciente.setRg(rg);
//        paciente.setDataDeAlta(dataDeAlta);
//
//        DentistaDTO dentista = new DentistaDTO();
//        int idDentista;
//        String nomeDentista = "Raquel";
//        String sobreNomeDentista = "Fernandes";
//        String matriculaDentista = "CD-15498";
//
//        dentista.setNome(nomeDentista);
//        dentista.setSobreNome(sobreNomeDentista);
//        dentista.setMatricula(matriculaDentista);
//
//        ConsultaDTO consulta = new ConsultaDTO();
//        LocalDateTime dataHoraConsulta = LocalDateTime.of(2022,3,11,10, 25, 30);
//        consulta.setPaciente(paciente);
//        consulta.setDentista(dentista);
//        consulta.setDataHoraConsulta(dataHoraConsulta);
//
//        consulta = consultaService.create(consulta);
//        idConsulta = consulta.getId();
//
////        consulta = dentistaService.getById(idConsulta);
//
//        assertTrue(consulta.getId() == idConsulta);

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
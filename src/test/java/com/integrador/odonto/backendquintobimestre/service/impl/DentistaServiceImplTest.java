package com.integrador.odonto.backendquintobimestre.service.impl;

import com.integrador.odonto.backendquintobimestre.entity.dto.DentistaDTO;
import com.integrador.odonto.backendquintobimestre.exception.NotFoundException;
import com.integrador.odonto.backendquintobimestre.exception.UniqueIndexException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
 class DentistaServiceImplTest {

    @Autowired
    private DentistaServiceImpl dentistaService;

    int id;
    String nome = "Helena";
    String sobreNome = "Melo de Campos";
    String matricula = "CD-12785";

    @Test
    @Order(1)
    void testCreate() throws UniqueIndexException {
        DentistaDTO dentistaDTO = new DentistaDTO();
        dentistaDTO.setNome(nome);
        dentistaDTO.setSobreNome(sobreNome);
        dentistaDTO.setMatricula(matricula);

        dentistaDTO = dentistaService.create(dentistaDTO);

        assertTrue(dentistaDTO.getNome().equals(nome));
        assertTrue(dentistaDTO.getSobreNome().equals(sobreNome));
        assertTrue(dentistaDTO.getMatricula().equals(matricula));
    }

    @Test
    @Order(2)
    void testGetById() throws NotFoundException, UniqueIndexException {
        String matricula = "CD-15492";

        DentistaDTO dentistaDTO = new DentistaDTO();
        dentistaDTO.setNome(nome);
        dentistaDTO.setSobreNome(sobreNome);
        dentistaDTO.setMatricula(matricula);

        dentistaDTO = dentistaService.create(dentistaDTO);
        id = dentistaDTO.getId();

        dentistaDTO = dentistaService.getById(id);

        assertTrue(dentistaDTO.getId() == id);
        assertTrue(dentistaDTO.getNome().equals(nome));
        assertTrue(dentistaDTO.getSobreNome().equals(sobreNome));
        assertTrue(dentistaDTO.getMatricula().equals(matricula));

    }

    @Test
    @Order(3)
    void testDelete() throws NotFoundException, UniqueIndexException {
        String matricula = "CD-48796";

        DentistaDTO dentistaDTO = new DentistaDTO();
        dentistaDTO.setNome(nome);
        dentistaDTO.setSobreNome(sobreNome);
        dentistaDTO.setMatricula(matricula);

        dentistaDTO = dentistaService.create(dentistaDTO);
        id = dentistaDTO.getId();

        dentistaService.delete(id);
        assertTrue(!dentistaService.ifDentistaExists(id));
    }

    @Test
    @Order(4)
    void testUpdate() throws UniqueIndexException, NotFoundException {
        String matricula = "16741";

        DentistaDTO dentistaDTO = new DentistaDTO();
        dentistaDTO.setNome(nome);
        dentistaDTO.setSobreNome(sobreNome);
        dentistaDTO.setMatricula(matricula);

        dentistaDTO = dentistaService.create(dentistaDTO);
        id = dentistaDTO.getId();

        dentistaDTO = dentistaService.getById(id);
        dentistaDTO.setId(id);
        dentistaDTO.setNome(nome + " updated");
        dentistaDTO.setSobreNome(sobreNome + " updated");
        dentistaDTO.setMatricula(matricula + " updated");

        dentistaService.update(dentistaDTO, id);
        dentistaDTO = dentistaService.getById(id);

        assertTrue(dentistaDTO.getId() == id);
        assertTrue(dentistaDTO.getNome().equals(nome + " updated"));
        assertTrue(dentistaDTO.getSobreNome().equals(sobreNome + " updated"));
        assertTrue(dentistaDTO.getMatricula().equals(matricula + " updated"));

    }

    @Test
    @Order(5)
    void testGetAll() throws UniqueIndexException {
        String matricula = "DP-156485";

        DentistaDTO dentistaDTO = new DentistaDTO();
        dentistaDTO.setNome(nome);
        dentistaDTO.setSobreNome(sobreNome);
        dentistaDTO.setMatricula(matricula);

        dentistaDTO = dentistaService.create(dentistaDTO);

        List<DentistaDTO> dentistaDTOList = dentistaService.getAll();
        assertTrue(dentistaDTOList.size() > 0);
    }

    @Test
    @Order(6)
    void testIfDentistaExists() throws UniqueIndexException {
        String matricula = "OP-154872";

        DentistaDTO dentistaDTO = new DentistaDTO();
        dentistaDTO.setNome(nome);
        dentistaDTO.setSobreNome(sobreNome);
        dentistaDTO.setMatricula(matricula);


        dentistaDTO = dentistaService.create(dentistaDTO);
        id = dentistaDTO.getId();

        assertTrue(dentistaService.ifDentistaExists(id));
    }
}
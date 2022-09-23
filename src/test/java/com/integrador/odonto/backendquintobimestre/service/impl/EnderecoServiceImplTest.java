package com.integrador.odonto.backendquintobimestre.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.integrador.odonto.backendquintobimestre.entity.dto.EnderecoDTO;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class EnderecoServiceImplTest {
    @Autowired
    private EnderecoServiceImpl enderecoService;
    
    int id;
    String rua = "Rodolfo Dantas";
    String numero = "101";
    String complemento = "Apto 208";
    String bairro = "Copacabana";

	@Test
	@Order(1)
	void testCreate() {
		EnderecoDTO enderecoDTO = new EnderecoDTO();
		enderecoDTO.setRua(rua);
		enderecoDTO.setNumero(numero);
		enderecoDTO.setComplemento(complemento);
		enderecoDTO.setBairro(bairro);
		
		enderecoDTO = enderecoService.create(enderecoDTO);
		
        assertTrue(enderecoDTO.getRua().equals(rua));
        assertTrue(enderecoDTO.getNumero().equals(numero));
        assertTrue(enderecoDTO.getComplemento().equals(complemento));
        assertTrue(enderecoDTO.getBairro().equals(bairro));
	}

	@Test
	@Order(2)
	void testGetById() {
		EnderecoDTO enderecoDTO = new EnderecoDTO();
		enderecoDTO.setRua(rua);
		enderecoDTO.setNumero(numero);
		enderecoDTO.setComplemento(complemento);
		enderecoDTO.setBairro(bairro);
		
		enderecoDTO = enderecoService.create(enderecoDTO);
		id = enderecoDTO.getId();
		
        enderecoDTO = enderecoService.getById(id);
        
        assertTrue(enderecoDTO.getId() == id);
        assertTrue(enderecoDTO.getRua().equals(rua));
        assertTrue(enderecoDTO.getNumero().equals(numero));
        assertTrue(enderecoDTO.getComplemento().equals(complemento));
        assertTrue(enderecoDTO.getBairro().equals(bairro));
	}

	@Test
	@Order(3)
	void testGetAll() {
		EnderecoDTO enderecoDTO = new EnderecoDTO();
		enderecoDTO.setRua(rua);
		enderecoDTO.setNumero(numero);
		enderecoDTO.setComplemento(complemento);
		enderecoDTO.setBairro(bairro);
		
		enderecoDTO = enderecoService.create(enderecoDTO);
        
		List<EnderecoDTO> enderecosDTO = enderecoService.getAll();
		assertTrue(enderecosDTO.size() > 0);
	}

	@Test
	@Order(4)
	void testUpdate() {
		EnderecoDTO enderecoDTO = new EnderecoDTO();
		enderecoDTO.setRua(rua);
		enderecoDTO.setNumero(numero);
		enderecoDTO.setComplemento(complemento);
		enderecoDTO.setBairro(bairro);
		
		enderecoDTO = enderecoService.create(enderecoDTO);
		id = enderecoDTO.getId();
		
		enderecoDTO = enderecoService.getById(id);
		enderecoDTO.setId(id);
		enderecoDTO.setRua(rua + " updated");
		enderecoDTO.setNumero(numero + " updated");
		enderecoDTO.setComplemento(complemento + " updated");
		enderecoDTO.setBairro(bairro + " updated");
		
		enderecoService.update(enderecoDTO, id);
		enderecoDTO = enderecoService.getById(id);
		
        assertTrue(enderecoDTO.getId() == id);
        assertTrue(enderecoDTO.getRua().equals(rua + " updated"));
        assertTrue(enderecoDTO.getNumero().equals(numero + " updated"));
        assertTrue(enderecoDTO.getComplemento().equals(complemento + " updated"));
        assertTrue(enderecoDTO.getBairro().equals(bairro + " updated"));
	}

	@Test
	@Order(5)
	void testIfEnderecoExists() {
		EnderecoDTO enderecoDTO = new EnderecoDTO();
		enderecoDTO.setRua(rua);
		enderecoDTO.setNumero(numero);
		enderecoDTO.setComplemento(complemento);
		enderecoDTO.setBairro(bairro);
		
		enderecoDTO = enderecoService.create(enderecoDTO);
		id = enderecoDTO.getId();
		
		assertTrue(enderecoService.ifEnderecoExists(id));
	}

	@Test
	@Order(6)
	void testDelete() {
		EnderecoDTO enderecoDTO = new EnderecoDTO();
		enderecoDTO.setRua(rua);
		enderecoDTO.setNumero(numero);
		enderecoDTO.setComplemento(complemento);
		enderecoDTO.setBairro(bairro);
		
		enderecoDTO = enderecoService.create(enderecoDTO);
		id = enderecoDTO.getId();
		
		enderecoService.delete(id);
		assertTrue(!enderecoService.ifEnderecoExists(id));
	}

}

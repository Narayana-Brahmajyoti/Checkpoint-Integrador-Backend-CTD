package com.integrador.odonto.backendquintobimestre.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.integrador.odonto.backendquintobimestre.entity.EnderecoEntity;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class IEnderecoRepositoryTest {
    @Autowired
    private IEnderecoRepository enderecoRepository;
    
    private int id;
    private String rua = "Rodolfo Dantas";
    private String numero = "101";
    private String complemento = "Apto 208";
    private String bairro = "Copacabana";

	@Test
	@Order(1)
	void testSave() {
		EnderecoEntity enderecoEntity = new EnderecoEntity();
		enderecoEntity.setRua(rua);
		enderecoEntity.setNumero(numero);
		enderecoEntity.setComplemento(complemento);
		enderecoEntity.setBairro(bairro);
		
        enderecoEntity = enderecoRepository.save(enderecoEntity);
		
        assertTrue(enderecoEntity.getRua().equals(rua));
        assertTrue(enderecoEntity.getNumero().equals(numero));
        assertTrue(enderecoEntity.getComplemento().equals(complemento));
        assertTrue(enderecoEntity.getBairro().equals(bairro));
	}

	@Test
	@Order(2)
	void testFindById() {
		EnderecoEntity enderecoEntity = new EnderecoEntity();
		enderecoEntity.setRua(rua);
		enderecoEntity.setNumero(numero);
		enderecoEntity.setComplemento(complemento);
		enderecoEntity.setBairro(bairro);
		
        enderecoEntity = enderecoRepository.save(enderecoEntity);
        id = enderecoEntity.getId();
		
		EnderecoEntity endereco = enderecoRepository.findById(id).get();
        
        assertTrue(endereco.getId() == id);
        assertTrue(endereco.getRua().equals(rua));
        assertTrue(endereco.getNumero().equals(numero));
        assertTrue(endereco.getComplemento().equals(complemento));
        assertTrue(endereco.getBairro().equals(bairro));
	}
	
	@Test
	@Order(3)
	void testFindAll() {
		EnderecoEntity enderecoEntity = new EnderecoEntity();
		enderecoEntity.setRua(rua);
		enderecoEntity.setNumero(numero);
		enderecoEntity.setComplemento(complemento);
		enderecoEntity.setBairro(bairro);
		
        enderecoEntity = enderecoRepository.save(enderecoEntity);
		
		List<EnderecoEntity> enderecosDB = enderecoRepository.findAll();
		assertTrue(enderecosDB.size() > 0);
	}

	@Test
	@Order(4)
	void testSaveAndFlush() {		
		EnderecoEntity enderecoEntity = new EnderecoEntity();
		enderecoEntity.setRua(rua);
		enderecoEntity.setNumero(numero);
		enderecoEntity.setComplemento(complemento);
		enderecoEntity.setBairro(bairro);
		
        enderecoEntity = enderecoRepository.save(enderecoEntity);
        id = enderecoEntity.getId();
		
		enderecoEntity = enderecoRepository.findById(id).get();
		enderecoEntity.setRua(rua + " updated");
		enderecoEntity.setNumero(numero + " updated");
		enderecoEntity.setComplemento(complemento + " updated");
		enderecoEntity.setBairro(bairro + " updated");
		
		enderecoRepository.saveAndFlush(enderecoEntity);

		enderecoEntity = enderecoRepository.findById(id).get();
        assertTrue(enderecoEntity.getId() == id);
        assertTrue(enderecoEntity.getRua().equals(rua + " updated"));
        assertTrue(enderecoEntity.getNumero().equals(numero + " updated"));
        assertTrue(enderecoEntity.getComplemento().equals(complemento + " updated"));
        assertTrue(enderecoEntity.getBairro().equals(bairro + " updated"));
	}

	@Test
	@Order(5)
	void testExistsById() {
		EnderecoEntity enderecoEntity = new EnderecoEntity();
		enderecoEntity.setRua(rua);
		enderecoEntity.setNumero(numero);
		enderecoEntity.setComplemento(complemento);
		enderecoEntity.setBairro(bairro);
		
        enderecoEntity = enderecoRepository.save(enderecoEntity);
        id = enderecoEntity.getId();
        
		assertTrue(enderecoRepository.existsById(id));
	}
	
	@Test
	@Order(6)
	void testDeleteById() {
		EnderecoEntity enderecoEntity = new EnderecoEntity();
		enderecoEntity.setRua(rua);
		enderecoEntity.setNumero(numero);
		enderecoEntity.setComplemento(complemento);
		enderecoEntity.setBairro(bairro);
		
        enderecoEntity = enderecoRepository.save(enderecoEntity);
        id = enderecoEntity.getId();
        
		enderecoRepository.deleteById(id);
		assertTrue(!enderecoRepository.existsById(id));
	}

}

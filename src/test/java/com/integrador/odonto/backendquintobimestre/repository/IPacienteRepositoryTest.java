package com.integrador.odonto.backendquintobimestre.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.integrador.odonto.backendquintobimestre.entity.PacienteEntity;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class IPacienteRepositoryTest {
	@Autowired
	private IPacienteRepository pacienteRepository;

	private int idPac;
	private String nome = "Paula";
	private String sobreNome = "Furlan";
	private String rg = "12345";
	private String dataDeAlta = "10/09/2022";
	
	@Test
	@Order(1)
	void testSave() {
		PacienteEntity pacienteEntity = new PacienteEntity();
		pacienteEntity.setNome(nome);
		pacienteEntity.setSobreNome(sobreNome);
		pacienteEntity.setRg(rg);
		pacienteEntity.setDataDeAlta(dataDeAlta);
    	
        pacienteEntity = pacienteRepository.save(pacienteEntity);
        
        assertTrue(pacienteEntity.getNome().equals(nome));
        assertTrue(pacienteEntity.getSobreNome().equals(sobreNome));
        assertTrue(pacienteEntity.getRg().equals(rg));
        assertTrue(pacienteEntity.getDataDeAlta().equals(dataDeAlta));
	}

	@Test
	@Order(2)
	void testFindById() {
		PacienteEntity pacienteEntity = new PacienteEntity();
		pacienteEntity.setNome(nome);
		pacienteEntity.setSobreNome(sobreNome);
		pacienteEntity.setRg(rg);
		pacienteEntity.setDataDeAlta(dataDeAlta);
    	
        pacienteEntity = pacienteRepository.save(pacienteEntity);
        idPac = pacienteEntity.getId();
        pacienteEntity = pacienteRepository.findById(idPac).get();
        
        assertTrue(pacienteEntity.getNome().equals(nome));
        assertTrue(pacienteEntity.getSobreNome().equals(sobreNome));
        assertTrue(pacienteEntity.getRg().equals(rg));
        assertTrue(pacienteEntity.getDataDeAlta().equals(dataDeAlta));
	}

	@Test
	@Order(3)
	void testFindAll() {
		PacienteEntity pacienteEntity = new PacienteEntity();
		pacienteEntity.setNome(nome);
		pacienteEntity.setSobreNome(sobreNome);
		pacienteEntity.setRg(rg);
		pacienteEntity.setDataDeAlta(dataDeAlta);
    	
        pacienteEntity = pacienteRepository.save(pacienteEntity);
        
		List<PacienteEntity> pacientesDB = pacienteRepository.findAll();
		assertTrue(pacientesDB.size() > 0);
	}
	
	@Test
	@Order(4)
	void testFindByNome() {
		PacienteEntity pacienteEntity = new PacienteEntity();
		pacienteEntity.setNome(nome);
		pacienteEntity.setSobreNome(sobreNome);
		pacienteEntity.setRg(rg);
		pacienteEntity.setDataDeAlta(dataDeAlta);
    	
        pacienteEntity = pacienteRepository.save(pacienteEntity);
        List<PacienteEntity> pacientes = pacienteRepository.findByNome(nome);
        
        assertTrue(pacientes.size() > 0);
        assertTrue(pacientes.get(0).getNome().equals(nome));
	}

	@Test
	@Order(5)
	void testFindBySobrenome() {
		PacienteEntity pacienteEntity = new PacienteEntity();
		pacienteEntity.setNome(nome);
		pacienteEntity.setSobreNome(sobreNome);
		pacienteEntity.setRg(rg);
		pacienteEntity.setDataDeAlta(dataDeAlta);
    	
        pacienteEntity = pacienteRepository.save(pacienteEntity);
        List<PacienteEntity> pacientes = pacienteRepository.findBySobrenome(sobreNome);
        
        assertTrue(pacientes.size() > 0);
        assertTrue(pacientes.get(0).getSobreNome().equals(sobreNome));
	}

	@Test
	@Order(6)
	void testFindByRg() {
		PacienteEntity pacienteEntity = new PacienteEntity();
		pacienteEntity.setNome(nome);
		pacienteEntity.setSobreNome(sobreNome);
		pacienteEntity.setRg(rg);
		pacienteEntity.setDataDeAlta(dataDeAlta);
    	
        pacienteEntity = pacienteRepository.save(pacienteEntity);
        List<PacienteEntity> pacientes = pacienteRepository.findByRg(rg);
        
        assertTrue(pacientes.size() > 0);
        assertTrue(pacientes.get(0).getRg().equals(rg));
	}

	@Test
	@Order(7)
	void testFindByDataDeAlta() {
		PacienteEntity pacienteEntity = new PacienteEntity();
		pacienteEntity.setNome(nome);
		pacienteEntity.setSobreNome(sobreNome);
		pacienteEntity.setRg(rg);
		pacienteEntity.setDataDeAlta(dataDeAlta);
    	
        pacienteEntity = pacienteRepository.save(pacienteEntity);
        List<PacienteEntity> pacientes = pacienteRepository.findByDataDeAlta(dataDeAlta);
        
        assertTrue(pacientes.size() > 0);
        assertTrue(pacientes.get(0).getDataDeAlta().equals(dataDeAlta));
	}

	@Test
	@Order(8)
	void testSaveAndFlush() {
		PacienteEntity pacienteEntity = new PacienteEntity();
		pacienteEntity.setNome(nome);
		pacienteEntity.setSobreNome(sobreNome);
		pacienteEntity.setRg(rg);
		pacienteEntity.setDataDeAlta(dataDeAlta);
    	
		pacienteEntity = pacienteRepository.save(pacienteEntity);
        idPac = pacienteEntity.getId();
        
		pacienteEntity.setNome(nome + " updated");
		pacienteEntity.setSobreNome(sobreNome + " updated");
		pacienteEntity.setRg(rg + " updated");
		pacienteEntity.setDataDeAlta(dataDeAlta + " updated");
		
		pacienteRepository.saveAndFlush(pacienteEntity);
		pacienteEntity = pacienteRepository.findById(idPac).get();

        assertTrue(pacienteEntity.getNome().equals(nome + " updated"));
        assertTrue(pacienteEntity.getSobreNome().equals(sobreNome + " updated"));
        assertTrue(pacienteEntity.getRg().equals(rg + " updated"));
        assertTrue(pacienteEntity.getDataDeAlta().equals(dataDeAlta + " updated"));
	}

	@Test
	@Order(9)
	void testExistsById() {
		PacienteEntity pacienteEntity = new PacienteEntity();
		pacienteEntity.setNome(nome);
		pacienteEntity.setSobreNome(sobreNome);
		pacienteEntity.setRg(rg);
		pacienteEntity.setDataDeAlta(dataDeAlta);
    	
		pacienteEntity = pacienteRepository.save(pacienteEntity);
        idPac = pacienteEntity.getId();
        
        assertTrue(pacienteRepository.existsById(idPac));
	}

	@Test
	@Order(10)
	void testDeleteById() {
		PacienteEntity pacienteEntity = new PacienteEntity();
		pacienteEntity.setNome(nome);
		pacienteEntity.setSobreNome(sobreNome);
		pacienteEntity.setRg(rg);
		pacienteEntity.setDataDeAlta(dataDeAlta);
    	
		pacienteEntity = pacienteRepository.save(pacienteEntity);
        idPac = pacienteEntity.getId();
        
        pacienteRepository.deleteById(idPac);
        assertTrue(!pacienteRepository.existsById(idPac));
	}

}

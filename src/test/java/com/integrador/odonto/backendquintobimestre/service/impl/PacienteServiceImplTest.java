package com.integrador.odonto.backendquintobimestre.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.integrador.odonto.backendquintobimestre.entity.EnderecoEntity;
import com.integrador.odonto.backendquintobimestre.entity.PacienteEntity;
import com.integrador.odonto.backendquintobimestre.entity.dto.EnderecoDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
import com.integrador.odonto.backendquintobimestre.exception.NotFoundException;

@SpringBootTest
class PacienteServiceImplTest {
	@Autowired
	private PacienteServiceImpl pacienteService;

    @Autowired
    private EnderecoServiceImpl enderecoService;
    
    EnderecoDTO endereco = new EnderecoDTO();
    
    PacienteDTO paciente = new PacienteDTO();
	
    @BeforeEach
    public void doBefore() {
        String rua = "Rua Rio Negro";
        String numero = "1234";
        String complemento = "apto 1104";
        String bairro = "Vera Cruz";

        endereco.setRua(rua);
        endereco.setNumero(numero);
        endereco.setComplemento(complemento);
        endereco.setBairro(bairro);
        
        String nomePaciente = "Gabriela";
        String sobreNomePaciente = "Carvalho";
        String rg = "MG-15678";
        String dataDeAlta = "25/10/2022";

        paciente.setNome(nomePaciente);
        paciente.setSobreNome(sobreNomePaciente);
        paciente.setEndereco(endereco);
        paciente.setRg(rg);
        paciente.setDataDeAlta(dataDeAlta);
            
    }

	@Test
	@Order(1)
	void testCreate() throws NotFoundException {
		EnderecoDTO enderecoDTO = endereco;
		enderecoDTO = enderecoService.create(enderecoDTO);
		
		PacienteDTO pacienteDTO = paciente;
		pacienteDTO.setEndereco(enderecoDTO);
		
		pacienteDTO = pacienteService.create(pacienteDTO);
		
		assertTrue(pacienteDTO.getNome().equals(paciente.getNome()));
		assertTrue(pacienteDTO.getSobreNome().equals(paciente.getSobreNome()));
		assertTrue(pacienteDTO.getRg().equals(paciente.getRg()));
		assertTrue(pacienteDTO.getDataDeAlta().equals(paciente.getDataDeAlta()));
	}

	@Test
	@Order(2)
	void testGetById() throws NotFoundException {
		EnderecoDTO enderecoDTO = endereco;
		enderecoDTO = enderecoService.create(enderecoDTO);
		
		PacienteDTO pacienteDTO = paciente;
		pacienteDTO.setEndereco(enderecoDTO);
		
		pacienteDTO = pacienteService.create(pacienteDTO);
		
		pacienteDTO = pacienteService.getById(pacienteDTO.getId());
		
		assertTrue(pacienteDTO.getNome().equals(paciente.getNome()));
		assertTrue(pacienteDTO.getSobreNome().equals(paciente.getSobreNome()));
		assertTrue(pacienteDTO.getRg().equals(paciente.getRg()));
		assertTrue(pacienteDTO.getDataDeAlta().equals(paciente.getDataDeAlta()));
	}

	@Test
	@Order(3)
	void testGetAll() throws NotFoundException {
		EnderecoEntity enderecoEntity = new EnderecoEntity(endereco);
		EnderecoDTO enderecoDTO = new EnderecoDTO(enderecoEntity);
		enderecoDTO = enderecoService.create(enderecoDTO);
		
		PacienteDTO pacienteDTO = paciente;
		pacienteDTO.setEndereco(enderecoDTO);
		
		pacienteDTO = pacienteService.create(pacienteDTO);
		
		List<PacienteDTO> pacientes = new ArrayList<>();
		//pacientes = pacienteService.getAll();
		//assertTrue(pacientes.size() > 0);
	}
	
	@Test
	@Order(4)
	void testGetByName() throws NotFoundException {
		EnderecoDTO enderecoDTO = endereco;
		enderecoDTO = enderecoService.create(enderecoDTO);
		
		PacienteDTO pacienteDTO = paciente;
		pacienteDTO.setEndereco(enderecoDTO);
		
		pacienteDTO = pacienteService.create(pacienteDTO);
		
		List<PacienteDTO> pacientes = pacienteService.getByName(paciente.getNome());
		assertTrue(pacientes.size() > 0);
	}

	@Test
	@Order(5)
	void testGetBySurname() throws NotFoundException {
		EnderecoDTO enderecoDTO = endereco;
		enderecoDTO = enderecoService.create(enderecoDTO);
		
		PacienteDTO pacienteDTO = paciente;
		pacienteDTO.setEndereco(enderecoDTO);
		
		pacienteDTO = pacienteService.create(pacienteDTO);
		
		List<PacienteDTO> pacientes = pacienteService.getBySurname(paciente.getSobreNome());
		assertTrue(pacientes.size() > 0);
	}

	@Test
	@Order(6)
	void testGetByRg() throws NotFoundException {
		EnderecoDTO enderecoDTO = endereco;
		enderecoDTO = enderecoService.create(enderecoDTO);
		
		PacienteDTO pacienteDTO = paciente;
		pacienteDTO.setEndereco(enderecoDTO);
		
		pacienteDTO = pacienteService.create(pacienteDTO);
		
		List<PacienteDTO> pacientes = pacienteService.getByRg(paciente.getRg());
		assertTrue(pacientes.size() > 0);
	}

	@Test
	@Order(7)
	void testGetByDataDeAlta() throws NotFoundException {
		EnderecoDTO enderecoDTO = endereco;
		enderecoDTO = enderecoService.create(enderecoDTO);
		
		PacienteDTO pacienteDTO = paciente;
		pacienteDTO.setEndereco(enderecoDTO);
		
		pacienteDTO = pacienteService.create(pacienteDTO);
		
		List<PacienteDTO> pacientes = pacienteService.getByDataDeAlta(paciente.getDataDeAlta());
		assertTrue(pacientes.size() > 0);
	}
	
	@Test
	@Order(8)
	void testUpdate() throws NotFoundException {
		EnderecoDTO enderecoDTO = endereco;
		enderecoDTO = enderecoService.create(enderecoDTO);
		
		PacienteDTO pacienteDTO = paciente;
		pacienteDTO.setEndereco(enderecoDTO);
		
		pacienteDTO = pacienteService.create(pacienteDTO);
		pacienteDTO = pacienteService.getById(pacienteDTO.getId());
		
		pacienteDTO.setNome(paciente.getNome() + " updated");
		pacienteDTO.setSobreNome(paciente.getSobreNome() + " updated");
		pacienteDTO.setRg(paciente.getRg() + " updated");
		pacienteDTO.setDataDeAlta(paciente.getDataDeAlta() + " updated");
		
		pacienteDTO = pacienteService.update(pacienteDTO, pacienteDTO.getId());
		pacienteDTO = pacienteService.getById(pacienteDTO.getId());
		
		assertTrue(pacienteDTO.getNome().equals(paciente.getNome() + " updated"));
		assertTrue(pacienteDTO.getSobreNome().equals(paciente.getSobreNome() + " updated"));
		assertTrue(pacienteDTO.getRg().equals(paciente.getRg() + " updated"));
		assertTrue(pacienteDTO.getDataDeAlta().equals(paciente.getDataDeAlta() + " updated"));
	}

	@Test
	@Order(9)
	void testDelete() throws NotFoundException {
		EnderecoDTO enderecoDTO = endereco;
		enderecoDTO = enderecoService.create(enderecoDTO);
		
		PacienteDTO pacienteDTO = paciente;
		pacienteDTO.setEndereco(enderecoDTO);
		
		pacienteDTO = pacienteService.create(pacienteDTO);
		
		int id = pacienteDTO.getId();
		pacienteService.delete(id);
		assertFalse(pacienteService.ifPacienteExists(id));

	}

}

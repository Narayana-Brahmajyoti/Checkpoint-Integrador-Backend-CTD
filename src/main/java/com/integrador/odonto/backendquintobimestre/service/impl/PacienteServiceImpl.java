package com.integrador.odonto.backendquintobimestre.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.odonto.backendquintobimestre.entity.EnderecoEntity;
import com.integrador.odonto.backendquintobimestre.entity.PacienteEntity;
import com.integrador.odonto.backendquintobimestre.entity.dto.EnderecoDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
import com.integrador.odonto.backendquintobimestre.repository.IPacienteRepository;
import com.integrador.odonto.backendquintobimestre.service.IClinicaService;


@Service
public class PacienteServiceImpl implements IClinicaService<PacienteDTO>{

    @Autowired
    private IPacienteRepository pacienteRepository;
    
    @Autowired
    private EnderecoServiceImpl enderecoService;
	
	@Override
	public PacienteDTO create(PacienteDTO pacienteDTO) {
        PacienteEntity pacienteEntity = new PacienteEntity(pacienteDTO);
        EnderecoDTO enderecoDTO;
        int idEndereco = pacienteEntity.getEnderecoEntity().getId();

        if (enderecoService.ifEnderecoExists(idEndereco)) {
        	enderecoDTO = enderecoService.getById(idEndereco);
            EnderecoEntity endereco = new EnderecoEntity(enderecoDTO);
            pacienteEntity.setEnderecoEntity(endereco);
            pacienteEntity = pacienteRepository.save(pacienteEntity);
        }

        pacienteDTO = new PacienteDTO(pacienteEntity);
        return pacienteDTO;

	}

	@Override
	public PacienteDTO getById(int id) {
        PacienteEntity pacienteEntity = pacienteRepository.findById(id).get();
        PacienteDTO pacienteDTO = new PacienteDTO(pacienteEntity);
        return pacienteDTO;
	}

	@Override
	public List<PacienteDTO> getAll() {
        return null;
	}

	@Override
	public String delete(int id) {
		return "";
	}

	@Override
	public PacienteDTO update(PacienteDTO pacienteDTO, int id) {
		return null;
	}


}

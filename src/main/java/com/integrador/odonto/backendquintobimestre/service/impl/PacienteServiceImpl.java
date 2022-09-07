package com.integrador.odonto.backendquintobimestre.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.odonto.backendquintobimestre.entity.EnderecoEntity;
import com.integrador.odonto.backendquintobimestre.entity.PacienteEntity;
import com.integrador.odonto.backendquintobimestre.entity.dto.EnderecoDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
import com.integrador.odonto.backendquintobimestre.repository.PacienteRepository;
import com.integrador.odonto.backendquintobimestre.service.IClinicaService;

@Service
public class PacienteServiceImpl implements IClinicaService<PacienteDTO>{

    @Autowired
    private PacienteRepository pacienteRepository;
	
	@Override
	public PacienteDTO create(PacienteDTO pacienteDTO) {
        PacienteEntity pacienteEntity = new PacienteEntity(pacienteDTO);
        pacienteRepository.create(pacienteEntity);
        return pacienteDTO;
	}

	@Override
	public PacienteDTO getById(int id) {
		return new PacienteDTO(pacienteRepository.getById(id));
	}

	@Override
	public List<PacienteDTO> getAll() {
        List<PacienteEntity> pacienteEntities = pacienteRepository.getAll();
        List<PacienteDTO> pacienteDTOs = new ArrayList<>();

        for (PacienteEntity paciente : pacienteEntities) {
            PacienteDTO pacienteDTO = new PacienteDTO(paciente);
            pacienteDTOs.add(pacienteDTO);
        }

        return pacienteDTOs;
	}

	@Override
	public String delete(int id) {
		return pacienteRepository.delete(id);
	}

	@Override
	public PacienteDTO update(PacienteDTO pacienteDTO, int id) {
		PacienteEntity pacienteEntity = new PacienteEntity(pacienteDTO);
		pacienteEntity.setId(id);
		pacienteRepository.update(pacienteEntity);

        return pacienteDTO;
	}

}

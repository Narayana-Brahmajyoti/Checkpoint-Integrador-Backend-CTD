package com.integrador.odonto.backendquintobimestre.service.impl;

import com.integrador.odonto.backendquintobimestre.entity.PacienteEntity;
import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
import com.integrador.odonto.backendquintobimestre.repository.IPacienteRepository;
import com.integrador.odonto.backendquintobimestre.service.IClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteServiceImpl implements IClinicaService<PacienteDTO>{

    @Autowired
    private IPacienteRepository pacienteRepository;

	@Autowired
	private EnderecoServiceImpl enderecoService;
	
	@Override
	public PacienteDTO create(PacienteDTO pacienteDTO) {
        PacienteEntity pacienteEntity = new PacienteEntity(pacienteDTO);
        pacienteEntity = pacienteRepository.save(pacienteEntity);
		pacienteDTO = new PacienteDTO(pacienteEntity);
        return pacienteDTO;
	}

	@Override
	public PacienteDTO getById(int id) {
		PacienteEntity paciente = pacienteRepository.findById(id).get();
		return new PacienteDTO(paciente);
	}

	@Override
	public List<PacienteDTO> getAll() {
        List<PacienteEntity> pacienteEntities = pacienteRepository.findAll();
        List<PacienteDTO> pacienteDTOs = new ArrayList<>();

        for (PacienteEntity paciente : pacienteEntities) {
            PacienteDTO pacienteDTO = new PacienteDTO(paciente);
            pacienteDTOs.add(pacienteDTO);
        }

        return pacienteDTOs;
	}

	@Override
	public String delete(int id) {
		return "Paciente deletado";
	}



	@Override
	public PacienteDTO update(PacienteDTO pacienteDTO, int id) {
		PacienteEntity pacienteEntity = new PacienteEntity(pacienteDTO);
		pacienteRepository.saveAndFlush (pacienteEntity);

		return pacienteDTO;
	}

}

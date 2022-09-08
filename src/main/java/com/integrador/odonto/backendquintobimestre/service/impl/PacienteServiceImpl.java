package com.integrador.odonto.backendquintobimestre.service.impl;

<<<<<<< HEAD
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
=======
import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
import com.integrador.odonto.backendquintobimestre.service.IClinicaService;
import org.springframework.stereotype.Service;

import java.util.List;
>>>>>>> diego

@Service
public class PacienteServiceImpl implements IClinicaService<PacienteDTO>{

<<<<<<< HEAD
    @Autowired
    private PacienteRepository pacienteRepository;
	
	@Override
	public PacienteDTO create(PacienteDTO pacienteDTO) {
        PacienteEntity pacienteEntity = new PacienteEntity(pacienteDTO);
        pacienteRepository.create(pacienteEntity);
        return pacienteDTO;
=======
	@Override
	public PacienteDTO create(PacienteDTO t) {
		// TODO Auto-generated method stub
		return null;
>>>>>>> diego
	}

	@Override
	public PacienteDTO getById(int id) {
<<<<<<< HEAD
		return new PacienteDTO(pacienteRepository.getById(id));
=======
		// TODO Auto-generated method stub
		return null;
>>>>>>> diego
	}

	@Override
	public List<PacienteDTO> getAll() {
<<<<<<< HEAD
        List<PacienteEntity> pacienteEntities = pacienteRepository.getAll();
        List<PacienteDTO> pacienteDTOs = new ArrayList<>();

        for (PacienteEntity paciente : pacienteEntities) {
            PacienteDTO pacienteDTO = new PacienteDTO(paciente);
            pacienteDTOs.add(pacienteDTO);
        }

        return pacienteDTOs;
=======
		// TODO Auto-generated method stub
		return null;
>>>>>>> diego
	}

	@Override
	public String delete(int id) {
<<<<<<< HEAD
		return pacienteRepository.delete(id);
	}

	@Override
	public PacienteDTO update(PacienteDTO pacienteDTO, int id) {
		PacienteEntity pacienteEntity = new PacienteEntity(pacienteDTO);
		pacienteEntity.setId(id);
		pacienteRepository.update(pacienteEntity);

        return pacienteDTO;
=======
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PacienteDTO update(PacienteDTO t, int id) {
		// TODO Auto-generated method stub
		return null;
>>>>>>> diego
	}

}

package com.integrador.odonto.backendquintobimestre.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
import com.integrador.odonto.backendquintobimestre.repository.PacienteRepository;
import com.integrador.odonto.backendquintobimestre.service.IClinicaService;

@Service
public class PacienteServiceImpl implements IClinicaService<PacienteDTO>{

    @Autowired
    private PacienteRepository pacienteRepository;
    
    @Autowired
    private EnderecoServiceImpl enderecoService;
	
	@Override
	public PacienteDTO create(PacienteDTO t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PacienteDTO getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PacienteDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PacienteDTO update(PacienteDTO t, int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

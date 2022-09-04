package com.integrador.odonto.backendquintobimestre.service.impl;

import com.integrador.odonto.backendquintobimestre.entity.DentistaEntity;
import com.integrador.odonto.backendquintobimestre.entity.EnderecoEntity;
import com.integrador.odonto.backendquintobimestre.entity.PacienteEntity;
import com.integrador.odonto.backendquintobimestre.entity.dto.DentistaDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.EnderecoDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
import com.integrador.odonto.backendquintobimestre.repository.DentistaRepository;
import com.integrador.odonto.backendquintobimestre.repository.EnderecoRepository;
import com.integrador.odonto.backendquintobimestre.repository.PacienteRepository;
import com.integrador.odonto.backendquintobimestre.service.IClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements IClinicaService<PacienteDTO> {
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
        return null;
    }
}

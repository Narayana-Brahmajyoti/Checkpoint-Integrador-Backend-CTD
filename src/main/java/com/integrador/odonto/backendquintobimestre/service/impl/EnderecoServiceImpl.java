package com.integrador.odonto.backendquintobimestre.service.impl;

import com.integrador.odonto.backendquintobimestre.entity.EnderecoEntity;
import com.integrador.odonto.backendquintobimestre.entity.dto.EnderecoDTO;
import com.integrador.odonto.backendquintobimestre.repository.EnderecoRepository;
import com.integrador.odonto.backendquintobimestre.service.IClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoServiceImpl implements IClinicaService<EnderecoDTO> {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public EnderecoDTO create(EnderecoDTO enderecoDTO) {
        EnderecoEntity enderecoEntity = new EnderecoEntity(enderecoDTO);
        enderecoRepository.create(enderecoEntity);
        return enderecoDTO;
    }

    @Override
    public EnderecoDTO getById(int id) {
        return null;
    }
}

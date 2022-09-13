package com.integrador.odonto.backendquintobimestre.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.odonto.backendquintobimestre.entity.EnderecoEntity;
import com.integrador.odonto.backendquintobimestre.entity.dto.EnderecoDTO;
import com.integrador.odonto.backendquintobimestre.repository.EnderecoRepository;
import com.integrador.odonto.backendquintobimestre.service.IClinicaService;


import java.util.ArrayList;
import java.util.List;


@Service
public class EnderecoServiceImpl implements IClinicaService<EnderecoDTO>{
    @Autowired
    private EnderecoRepository enderecoRepository;

	@Override
	public EnderecoDTO create(EnderecoDTO enderecoDTO) {
        EnderecoEntity enderecoEntity = new EnderecoEntity(enderecoDTO);
        enderecoRepository.create(enderecoEntity);
        enderecoDTO.setId(enderecoEntity.getId());
        return enderecoDTO;
	}

	@Override
	public EnderecoDTO getById(int id) {
        return new EnderecoDTO(enderecoRepository.getById(id));
	}

	@Override
	public List<EnderecoDTO> getAll() {
        List<EnderecoEntity> enderecoEntities = enderecoRepository.getAll();
        List<EnderecoDTO> enderecoDTOs = new ArrayList<>();

        for (EnderecoEntity endereco : enderecoEntities) {
            EnderecoDTO enderecoDTO = new EnderecoDTO(endereco);
            enderecoDTOs.add(enderecoDTO);
        }

        return enderecoDTOs;
	}

	@Override
	public String delete(int id) {
        return enderecoRepository.delete(id);
	}

	@Override
	public EnderecoDTO update(EnderecoDTO enderecoDTO, int id) {

		enderecoDTO.setId(id);

		EnderecoEntity enderecoEntity = new EnderecoEntity(enderecoDTO);
		enderecoRepository.update(enderecoEntity);

        return enderecoDTO;
	}

}

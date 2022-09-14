package com.integrador.odonto.backendquintobimestre.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.integrador.odonto.backendquintobimestre.repository.IEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.odonto.backendquintobimestre.entity.EnderecoEntity;
import com.integrador.odonto.backendquintobimestre.entity.dto.EnderecoDTO;
import com.integrador.odonto.backendquintobimestre.repository.EnderecoRepository;
import com.integrador.odonto.backendquintobimestre.service.IClinicaService;

@Service
public class EnderecoServiceImpl implements IClinicaService<EnderecoDTO>{
    @Autowired
    private IEnderecoRepository enderecoRepository;
	
	@Override
	public EnderecoDTO create(EnderecoDTO enderecoDTO) {
		EnderecoEntity enderecoEntity = new EnderecoEntity(enderecoDTO);
		enderecoEntity = enderecoRepository.save(enderecoEntity);
		enderecoDTO = new EnderecoDTO(enderecoEntity);
		return enderecoDTO;
	}

	@Override
	public EnderecoDTO getById(int id) {
		EnderecoEntity endereco = enderecoRepository.findById(id).get();
		return new EnderecoDTO(endereco);
	}

	@Override
	public List<EnderecoDTO> getAll() {
        List<EnderecoEntity> enderecoEntities = enderecoRepository.findAll();
        List<EnderecoDTO> enderecoDTOs = new ArrayList<>();

        for (EnderecoEntity endereco : enderecoEntities) {
            EnderecoDTO enderecoDTO = new EnderecoDTO(endereco);
            enderecoDTOs.add(enderecoDTO);
        }

        return enderecoDTOs;
	}

	@Override
	public String delete(int id) {
        enderecoRepository.deleteById(id);
		return "Endereço deletado";
	}

	@Override
	public EnderecoDTO update(EnderecoDTO enderecoDTO, int id) {
		EnderecoEntity enderecoEntity = new EnderecoEntity(enderecoDTO);
		enderecoRepository.saveAndFlush(enderecoEntity);

        return enderecoDTO;
	}

}

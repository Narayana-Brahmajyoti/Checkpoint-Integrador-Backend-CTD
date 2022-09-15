package com.integrador.odonto.backendquintobimestre.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.odonto.backendquintobimestre.entity.EnderecoEntity;
import com.integrador.odonto.backendquintobimestre.entity.dto.EnderecoDTO;
import com.integrador.odonto.backendquintobimestre.repository.IEnderecoRepository;
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
        return null;
	}

	@Override
	public String delete(int id) {
        return null;
	}

	@Override
	public EnderecoDTO update(EnderecoDTO enderecoDTO, int id) {
        return null;
	}
	
    public boolean ifEnderecoExists(int id) {
        return enderecoRepository.existsById(id);
    }

}

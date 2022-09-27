package com.integrador.odonto.backendquintobimestre.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.integrador.odonto.backendquintobimestre.exception.NotFoundException;
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
	public EnderecoDTO getById(int id) throws NotFoundException {
		EnderecoEntity endereco = enderecoRepository.findById(id).orElseThrow(() -> new NotFoundException("Endereço não encontrado com o id: " + id));
        return new EnderecoDTO(endereco);
	}

	@Override
	public List<EnderecoDTO> getAll() {
		List<EnderecoEntity> enderecosDB = enderecoRepository.findAll();
		List<EnderecoDTO> enderecosDTO = new ArrayList<>();
		
		for(EnderecoEntity endereco : enderecosDB)
		{
			EnderecoDTO enderecoDTO = new EnderecoDTO(endereco);
			enderecosDTO.add(enderecoDTO);
		}
		
        return enderecosDTO;
	}

	@Override
	public String delete(int id) throws NotFoundException {
		try{
			enderecoRepository.deleteById(id);
			return "Endereço de id " + id + " foi deletado";
		} catch (Exception ex){
			throw new NotFoundException("Não foi possível deletar endereço de id: " + id + ", id inexistente");
		}

	}

	@Override
	public EnderecoDTO update(EnderecoDTO enderecoDTO, int id) throws NotFoundException {
		EnderecoEntity enderecoEntity = enderecoRepository.findById(id).orElseThrow(() -> new NotFoundException("Endereço não encontrado com o id: " + id));

		enderecoEntity.setRua(enderecoDTO.getRua());
		enderecoEntity.setNumero(enderecoDTO.getNumero());
		enderecoEntity.setComplemento(enderecoDTO.getComplemento());
		enderecoEntity.setBairro(enderecoDTO.getBairro());
		
		enderecoEntity = enderecoRepository.saveAndFlush(enderecoEntity);
		EnderecoDTO enderecoDTO1 = new EnderecoDTO(enderecoEntity);
        return enderecoDTO1;
	}
	
    public boolean ifEnderecoExists(int id) {
        return enderecoRepository.existsById(id);
    }

}
package com.integrador.odonto.backendquintobimestre.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.odonto.backendquintobimestre.entity.EnderecoEntity;
import com.integrador.odonto.backendquintobimestre.entity.PacienteEntity;
import com.integrador.odonto.backendquintobimestre.entity.dto.EnderecoDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
import com.integrador.odonto.backendquintobimestre.repository.IPacienteRepository;
import com.integrador.odonto.backendquintobimestre.service.IClinicaService;

@Service
public class PacienteServiceImpl implements IClinicaService<PacienteDTO>{
    @Autowired
    private IPacienteRepository pacienteRepository;
    
    @Autowired
    private EnderecoServiceImpl enderecoService;
	
	@Override
	public PacienteDTO create(PacienteDTO pacienteDTO) {
        PacienteEntity pacienteEntity = new PacienteEntity(pacienteDTO);
        int idEndereco = pacienteEntity.getEnderecoEntity().getId();
        EnderecoDTO enderecoDTO = pacienteDTO.getEndereco();

        if (enderecoService.ifEnderecoExists(idEndereco)) 
            enderecoService.update(enderecoDTO, idEndereco);
        else 
        	enderecoDTO = enderecoService.create(enderecoDTO);
        
        
    	pacienteEntity.setEnderecoEntity(new EnderecoEntity(enderecoDTO));
    	
        pacienteEntity = pacienteRepository.save(pacienteEntity);

        pacienteDTO = new PacienteDTO(pacienteEntity);
        
        return pacienteDTO;
	}

	@Override
	public PacienteDTO getById(int id) {
        PacienteEntity pacienteEntity = pacienteRepository.findById(id).get();
        PacienteDTO pacienteDTO = new PacienteDTO(pacienteEntity);
        return pacienteDTO;
	}

	@Override
	public List<PacienteDTO> getAll() {
		List<PacienteEntity> pacientesDB = pacienteRepository.findAll();
		List<PacienteDTO> pacientesDTO = new ArrayList<>();
		
		for(PacienteEntity paciente : pacientesDB)
		{
			PacienteDTO pacienteDTO = new PacienteDTO(paciente);
			pacientesDTO.add(pacienteDTO);
		}
		
        return pacientesDTO;
	}

	@Override
	public String delete(int id) {
		pacienteRepository.deleteById(id);
		return "O paciente de id " + id + " foi deletado";
	}

	@Override
	public PacienteDTO update(PacienteDTO pacienteDTO, int id) {
		PacienteEntity pacienteEntity = pacienteRepository.findById(id).get();
		EnderecoDTO enderecoDTO;
        int idEndereco = pacienteDTO.getEndereco().getId();
		
		if(enderecoService.ifEnderecoExists(idEndereco)) {
			pacienteEntity.setNome(pacienteDTO.getNome());
			pacienteEntity.setSobreNome(pacienteDTO.getSobreNome());
			pacienteEntity.setRg(pacienteDTO.getRg());
			pacienteEntity.setDataDeAlta(pacienteDTO.getDataDeAlta());
			
			pacienteEntity.setEnderecoEntity(new EnderecoEntity(pacienteDTO.getEndereco()));			
			pacienteRepository.saveAndFlush(pacienteEntity);

        	enderecoDTO = enderecoService.getById(idEndereco);
        	enderecoService.update(enderecoDTO, idEndereco);
		}
		
		return pacienteDTO;
	}


}

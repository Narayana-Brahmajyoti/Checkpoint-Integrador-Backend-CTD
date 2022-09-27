package com.integrador.odonto.backendquintobimestre.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.integrador.odonto.backendquintobimestre.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.odonto.backendquintobimestre.exception.NotFoundException;
import com.integrador.odonto.backendquintobimestre.entity.EnderecoEntity;
import com.integrador.odonto.backendquintobimestre.entity.PacienteEntity;
import com.integrador.odonto.backendquintobimestre.entity.dto.EnderecoDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
import com.integrador.odonto.backendquintobimestre.service.IClinicaService;

@Service
public class PacienteServiceImpl implements IClinicaService<PacienteDTO>{
    @Autowired
    private IPacienteRepository pacienteRepository;
    
    @Autowired
    private EnderecoServiceImpl enderecoService;
	
	@Override
	public PacienteDTO create(PacienteDTO pacienteDTO) throws NotFoundException {
		EnderecoDTO enderecoDTO = enderecoService.getById(pacienteDTO.getEndereco().getId());
        PacienteEntity pacienteEntity = new PacienteEntity(pacienteDTO, enderecoDTO);
        int idEndereco = pacienteDTO.getEndereco().getId();

        if (enderecoService.ifEnderecoExists(idEndereco))
			pacienteEntity = pacienteRepository.save(pacienteEntity);
//            enderecoService.update(enderecoDTO, idEndereco);
//        else
//        	enderecoService.create(enderecoDTO);

			//pacienteEntity.setEnderecoEntity(new EnderecoEntity(enderecoDTO));

			//pacienteEntity = pacienteRepository.save(pacienteEntity);

			pacienteDTO = new PacienteDTO(pacienteEntity);

        return pacienteDTO;
	}

	@Override
	public PacienteDTO getById(int id) throws NotFoundException {
        PacienteEntity pacienteEntity = pacienteRepository.findById(id).orElseThrow(() -> new NotFoundException("Paciente não encontrado com o id: " + id));
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
	public String delete(int id) throws NotFoundException{
		try{
			pacienteRepository.deleteById(id);
			return "Paciente de id " + id + " foi deletado";
		} catch (Exception ex){
			throw new NotFoundException("Não foi possível deletar paciente de id: " + id + ", id inexistente");
		}
	}

	@Override
	public PacienteDTO update(PacienteDTO pacienteDTO, int id) throws NotFoundException {
		PacienteEntity pacienteEntity = pacienteRepository.findById(id).orElseThrow(() -> new NotFoundException("Paciente não encontrado com o id: " + id));
		EnderecoDTO enderecoDTO = enderecoService.getById(pacienteDTO.getEndereco().getId());
        int idEndereco = pacienteDTO.getEndereco().getId();
		
		if(enderecoService.ifEnderecoExists(idEndereco)) {
			pacienteEntity.setNome(pacienteDTO.getNome());
			pacienteEntity.setSobreNome(pacienteDTO.getSobreNome());
			pacienteEntity.setRg(pacienteDTO.getRg());
			pacienteEntity.setDataDeAlta(pacienteDTO.getDataDeAlta());
			
			pacienteEntity.setEnderecoEntity(new EnderecoEntity(enderecoDTO));			
			pacienteRepository.saveAndFlush(pacienteEntity);


        	//enderecoDTO = enderecoService.getById(idEndereco);
        	//enderecoService.update(enderecoDTO, idEndereco);
		}
		PacienteDTO pacienteDTO1 = new PacienteDTO(pacienteEntity);
		return pacienteDTO1;
	}

	public List<PacienteDTO> getByName(String nome){
		List<PacienteEntity> pacientes = pacienteRepository.findByNome(nome);
		List<PacienteDTO> pacientesDTO = new ArrayList<>();
		for(PacienteEntity paciente : pacientes)
			pacientesDTO.add(new PacienteDTO(paciente));
		
		return pacientesDTO;
	}

	public List<PacienteDTO> getBySurname(String sobrenome){
		List<PacienteEntity> pacientes = pacienteRepository.findBySobrenome(sobrenome);
		List<PacienteDTO> pacientesDTO = new ArrayList<>();
		for(PacienteEntity paciente : pacientes)
			pacientesDTO.add(new PacienteDTO(paciente));
		
		return pacientesDTO;
	}

	public List<PacienteDTO> getByRg(String rg){
		List<PacienteEntity> pacientes = pacienteRepository.findByRg(rg);
		List<PacienteDTO> pacientesDTO = new ArrayList<>();
		for(PacienteEntity paciente : pacientes)
			pacientesDTO.add(new PacienteDTO(paciente));
		
		return pacientesDTO;
	}

	public List<PacienteDTO> getByDataDeAlta(String dataDeAlta){
		List<PacienteEntity> pacientes = pacienteRepository.findByDataDeAlta(dataDeAlta);
		List<PacienteDTO> pacientesDTO = new ArrayList<>();
		for(PacienteEntity paciente : pacientes)
			pacientesDTO.add(new PacienteDTO(paciente));
		
		return pacientesDTO;
	}

	public boolean ifPacienteExists(int id){
		return pacienteRepository.existsById(id);
	}
}
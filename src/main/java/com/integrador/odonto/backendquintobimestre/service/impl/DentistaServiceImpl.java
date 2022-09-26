package com.integrador.odonto.backendquintobimestre.service.impl;


import com.integrador.odonto.backendquintobimestre.entity.DentistaEntity;
import com.integrador.odonto.backendquintobimestre.entity.dto.DentistaDTO;
import com.integrador.odonto.backendquintobimestre.exception.NotFoundException;
import com.integrador.odonto.backendquintobimestre.exception.UniqueIndexException;
import com.integrador.odonto.backendquintobimestre.repository.IDentistaRepository;
import com.integrador.odonto.backendquintobimestre.service.IClinicaService;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class DentistaServiceImpl implements IClinicaService<DentistaDTO> {

    @Autowired
    private IDentistaRepository dentistaRepository;

    @Override
    public DentistaDTO create(DentistaDTO dentistaDTO) throws UniqueIndexException {
        DentistaEntity dentistaEntity = new DentistaEntity(dentistaDTO);
        String matricula = dentistaDTO.getMatricula();
        String matriculaBD = String.valueOf(dentistaRepository.findByMatricula(matricula));
        if(!matricula.equalsIgnoreCase(matriculaBD))
            try {
                dentistaEntity = dentistaRepository.save(dentistaEntity);
            } catch (Exception ex){
                throw new UniqueIndexException("Matricula " + matricula + " já cadastrada no sistema");
            }

        dentistaDTO = new DentistaDTO(dentistaEntity);
        return dentistaDTO;
    }

    @Override
    public DentistaDTO getById(int id) throws NotFoundException {
        return new DentistaDTO(dentistaRepository.findById(id).orElseThrow(() -> new NotFoundException("Dentista não encontrado com o id: " + id)));
    }


	@Override
	public String delete(int id) throws NotFoundException {
        try{
            dentistaRepository.deleteById(id);
            return "Dentista de id " + id + " foi deletado";
        } catch (Exception ex){
            throw new NotFoundException("Não foi possível deletar dentista de id: " + id + ", id inexistente");
        }
	}

	@Override
	public DentistaDTO update(DentistaDTO dentistaDTO, int id) throws NotFoundException {

<<<<<<< HEAD
        DentistaEntity dentistaEntity = new DentistaEntity(dentistaDTO);
        dentistaEntity = dentistaRepository.findById(id).get();
        dentistaEntity.setNome(dentistaDTO.getNome());
        dentistaEntity.setSobreNome(dentistaDTO.getSobreNome());
        dentistaEntity.setMatricula(dentistaDTO.getMatricula());
        dentistaRepository.saveAndFlush(dentistaEntity);
        return dentistaDTO;
=======
            DentistaEntity dentistaEntity = new DentistaEntity(dentistaDTO);
            dentistaEntity = dentistaRepository.findById(id).orElseThrow(() -> new NotFoundException("Dentista não encontrado com o id: " + id));

            dentistaEntity.setNome(dentistaDTO.getNome());
            dentistaEntity.setSobreNome(dentistaDTO.getSobreNome());
            dentistaEntity.setMatricula(dentistaDTO.getMatricula());
            dentistaEntity = dentistaRepository.saveAndFlush(dentistaEntity);

        DentistaDTO dentistaDTO1 = new DentistaDTO(dentistaEntity);
        return dentistaDTO1;
>>>>>>> af10d6eef2344e2c5a6e49e6e8576a3aba876ea6
	}

    @Override
    public List<DentistaDTO> getAll() {
        List<DentistaEntity> dentistaEntities = dentistaRepository.findAll();
        List<DentistaDTO> dentistaDTOS = new ArrayList<>();
        for (DentistaEntity dentista : dentistaEntities) {
            DentistaDTO dentistaDTO = new DentistaDTO(dentista);
            dentistaDTOS.add(dentistaDTO);
        }
        return dentistaDTOS;
    }

    public DentistaDTO getByName(String nome){
        DentistaEntity dentista = dentistaRepository.findByNome(nome);
        DentistaDTO dentistaDTO = new DentistaDTO(dentista);
        return dentistaDTO;
    }

    public boolean ifDentistaExists(int id){
        return dentistaRepository.existsById(id);
    }
}


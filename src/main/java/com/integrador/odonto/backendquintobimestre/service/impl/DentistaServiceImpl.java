package com.integrador.odonto.backendquintobimestre.service.impl;


import com.integrador.odonto.backendquintobimestre.entity.DentistaEntity;
import com.integrador.odonto.backendquintobimestre.entity.PacienteEntity;
import com.integrador.odonto.backendquintobimestre.entity.dto.DentistaDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
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
    public DentistaDTO create(DentistaDTO dentistaDTO) {
        DentistaEntity dentistaEntity = new DentistaEntity(dentistaDTO);
        dentistaEntity = dentistaRepository.save(dentistaEntity);
        dentistaDTO = new DentistaDTO(dentistaEntity);
        return dentistaDTO;
    }

    @Override
    public DentistaDTO getById(int id) {
        return new DentistaDTO(dentistaRepository.findById(id).get());
    }


	@Override
	public String delete(int id) {
         dentistaRepository.deleteById(id);
         return "Dentista deletado com sucesso";
	}

	@Override
	public DentistaDTO update(DentistaDTO dentistaDTO, int id) {

        DentistaEntity dentistaEntity = new DentistaEntity(dentistaDTO);
        dentistaEntity = dentistaRepository.findById(id).get();

        dentistaEntity.setNome(dentistaDTO.getNome());
        dentistaEntity.setSobreNome(dentistaDTO.getSobreNome());
        dentistaEntity.setMatricula(dentistaDTO.getMatricula());
        dentistaRepository.saveAndFlush(dentistaEntity);

        return dentistaDTO;
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
}

package com.integrador.odonto.backendquintobimestre.service.impl;


import com.integrador.odonto.backendquintobimestre.entity.DentistaEntity;
import com.integrador.odonto.backendquintobimestre.entity.dto.DentistaDTO;
import com.integrador.odonto.backendquintobimestre.repository.IDentistaRepository;
import com.integrador.odonto.backendquintobimestre.service.IClinicaService;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DentistaServiceImpl implements IClinicaService<DentistaDTO> {

    @Autowired
    private IDentistaRepository dentistaRepository;


    @Override
    public DentistaDTO create(DentistaDTO dentistaDTO) {
        DentistaEntity dentistaEntity = new DentistaEntity(dentistaDTO);
        dentistaRepository.save(dentistaEntity);
        return dentistaDTO;
    }

    @Override
    public DentistaDTO getById(int id) {
        DentistaEntity dentista = dentistaRepository.findById(id).get();
        return new DentistaDTO(dentista);
    }

	@Override
	public List<DentistaDTO> getAll() {

        List<DentistaEntity> dentistaEntities = dentistaRepository.findAll();
        List<DentistaDTO> dentistaDTOs = new ArrayList<>();

        for (DentistaEntity dentista : dentistaEntities) {
            DentistaDTO dentistaDTO = new DentistaDTO(dentista);
            dentistaDTOs.add(dentistaDTO);
        }

        return dentistaDTOs;
	}

	@Override
	public String delete(int id) {
		return "Dentista deletado";
	}

	@Override
	public DentistaDTO update(DentistaDTO dentistaDTO, int id) {
		DentistaEntity dentistaEntity = new DentistaEntity(dentistaDTO);
        dentistaRepository.saveAndFlush(dentistaEntity);

		return dentistaDTO;

	}
}

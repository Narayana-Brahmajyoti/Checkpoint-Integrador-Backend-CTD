package com.integrador.odonto.backendquintobimestre.service.impl;


import com.integrador.odonto.backendquintobimestre.entity.DentistaEntity;
import com.integrador.odonto.backendquintobimestre.entity.PacienteEntity;
import com.integrador.odonto.backendquintobimestre.entity.dto.DentistaDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
import com.integrador.odonto.backendquintobimestre.repository.DentistaRepository;
import com.integrador.odonto.backendquintobimestre.service.IClinicaService;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DentistaServiceImpl implements IClinicaService<DentistaDTO> {

    @Autowired
    private DentistaRepository dentistaRepository;

    @Override
    public DentistaDTO create(DentistaDTO dentistaDTO) {
        DentistaEntity dentistaEntity = new DentistaEntity(dentistaDTO);
        dentistaRepository.create(dentistaEntity);
        return dentistaDTO;
    }

    @Override
    public DentistaDTO getById(int id) {
        return new DentistaDTO(dentistaRepository.getById(id));
    }


	@Override
	public String delete(int id) {
        return dentistaRepository.delete(id);
	}

	@Override
	public DentistaDTO update(DentistaDTO dentistaDTO, int id) {
		DentistaEntity dentistaEntity = new DentistaEntity(dentistaDTO);
        dentistaEntity = dentistaRepository.update(dentistaEntity);
        dentistaDTO = new DentistaDTO(dentistaEntity);
		return dentistaDTO;

	}

    @Override
    public List<DentistaDTO> getAll() {

        List<DentistaEntity> dentistaEntities = dentistaRepository.getAll();
        List<DentistaDTO> dentistaDTOS = new ArrayList<>();

        for (DentistaEntity dentista : dentistaEntities) {
            DentistaDTO dentistaDTO = new DentistaDTO(dentista);
            dentistaDTOS.add(dentistaDTO);
        }

        return dentistaDTOS;

    }
}

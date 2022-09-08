package com.integrador.odonto.backendquintobimestre.service.impl;


import com.integrador.odonto.backendquintobimestre.entity.DentistaEntity;
import com.integrador.odonto.backendquintobimestre.entity.dto.DentistaDTO;
import com.integrador.odonto.backendquintobimestre.repository.DentistaRepository;
import com.integrador.odonto.backendquintobimestre.service.IClinicaService;
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
	public List<DentistaDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DentistaDTO update(DentistaDTO dentistaDTO, int id) {
		DentistaEntity dentistaEntity = new DentistaEntity(dentistaDTO);
        dentistaEntity = dentistaRepository.update(dentistaEntity);
        dentistaDTO = new DentistaDTO(dentistaEntity);
		return dentistaDTO;

	}
}

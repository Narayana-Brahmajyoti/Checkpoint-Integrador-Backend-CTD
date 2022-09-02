package com.integrador.odonto.backendquintobimestre.service.impl;


import com.integrador.odonto.backendquintobimestre.entity.dto.DentistaDTO;
import com.integrador.odonto.backendquintobimestre.service.IClinicaService;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class DentistaServiceImpl implements IClinicaService<DentistaDTO> {


    @Override
    public DentistaDTO create(DentistaDTO dentistaDTO) {
        return null;
    }

    @Override
    public DentistaDTO getById(int id) {
        return null;
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
	public DentistaDTO update(DentistaDTO t, int id) {
		// TODO Auto-generated method stub
		return null;
	}
}

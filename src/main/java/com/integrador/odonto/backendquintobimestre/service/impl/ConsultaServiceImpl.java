package com.integrador.odonto.backendquintobimestre.service.impl;

import com.integrador.odonto.backendquintobimestre.entity.ConsultaEntity;
import com.integrador.odonto.backendquintobimestre.entity.dto.ConsultaDTO;
import com.integrador.odonto.backendquintobimestre.repository.IConsultaRepository;
import com.integrador.odonto.backendquintobimestre.service.IClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaServiceImpl implements IClinicaService<ConsultaDTO> {

    @Autowired
    private IConsultaRepository consultaRepository;

    @Override
    public ConsultaDTO create(ConsultaDTO consultaDTO) {
        ConsultaEntity consultaEntity = new ConsultaEntity(consultaDTO);
        consultaEntity = consultaRepository.save(consultaEntity);
        consultaDTO = new ConsultaDTO(consultaEntity);
        return consultaDTO;
    }

    @Override
    public ConsultaDTO getById(int id) {
        ConsultaEntity consulta = consultaRepository.findById(id).get();
        return new ConsultaDTO(consulta);
    }

    @Override
    public List<ConsultaDTO> getAll() {
        return null;
    }

    @Override
    public String delete(int id) {
        return null;
    }

    @Override
    public ConsultaDTO update(ConsultaDTO consultaDTO, int id) {
        return null;
    }

    public boolean ifConsultaExists(int id) {
        return consultaRepository.existsById(id);
    }


}

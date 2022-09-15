package com.integrador.odonto.backendquintobimestre.service.impl;

import com.integrador.odonto.backendquintobimestre.entity.ConsultaEntity;
import com.integrador.odonto.backendquintobimestre.entity.PacienteEntity;
import com.integrador.odonto.backendquintobimestre.entity.dto.ConsultaDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
import com.integrador.odonto.backendquintobimestre.repository.IConsultaRepository;
import com.integrador.odonto.backendquintobimestre.service.IClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<ConsultaEntity> consultaEntities = consultaRepository.findAll();
        List<ConsultaDTO> consultaDTOs = new ArrayList<>();

        for (ConsultaEntity consulta : consultaEntities) {
            ConsultaDTO consultaDTO = new ConsultaDTO(consulta);
            consultaDTOs.add(consultaDTO);
        }

        return consultaDTOs;
    }

    @Override
    public String delete(int id) {
        return  "Consulta deletada";
    }

    @Override
    public ConsultaDTO update(ConsultaDTO consultaDTO, int id) {
        ConsultaEntity consultaEntity = new ConsultaEntity(consultaDTO);
        consultaRepository.saveAndFlush(consultaEntity);

        return consultaDTO;
    }

    public boolean ifConsultaExists(int id) {
        return consultaRepository.existsById(id);
    }

    public ConsultaDTO getByPaciente(String name){
        ConsultaEntity consulta = consultaRepository.findByPaciente(name);
        ConsultaDTO consultaDTO = new ConsultaDTO(consulta);
        return consultaDTO;
    }

}

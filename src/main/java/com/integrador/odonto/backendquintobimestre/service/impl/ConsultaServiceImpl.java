package com.integrador.odonto.backendquintobimestre.service.impl;

import com.integrador.odonto.backendquintobimestre.entity.ConsultaEntity;
import com.integrador.odonto.backendquintobimestre.entity.DentistaEntity;
import com.integrador.odonto.backendquintobimestre.entity.PacienteEntity;
import com.integrador.odonto.backendquintobimestre.entity.dto.ConsultaDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.DentistaDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
import com.integrador.odonto.backendquintobimestre.exception.NotFoundException;
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

    @Autowired
    private PacienteServiceImpl pacienteService;

    @Autowired
    private DentistaServiceImpl dentistaService;

    @Override
    public ConsultaDTO create(ConsultaDTO consultaDTO) throws NotFoundException {
        ConsultaEntity consultaEntity = new ConsultaEntity(consultaDTO);
        PacienteDTO pacienteDTO;
        DentistaDTO dentistaDTO;

        int idPaciente = consultaEntity.getPaciente().getId();
        int idDentista = consultaEntity.getDentista().getId();

        if(pacienteService.ifPacienteExists(idPaciente) && dentistaService.ifDentistaExists(idDentista)) {
            pacienteDTO = pacienteService.getById(idPaciente);
            dentistaDTO = dentistaService.getById(idDentista);
            PacienteEntity paciente = new PacienteEntity(pacienteDTO);
            DentistaEntity dentista = new DentistaEntity(dentistaDTO);
            consultaEntity.setPaciente(paciente);
            consultaEntity.setDentista(dentista);
            consultaEntity = consultaRepository.save(consultaEntity);

        }
        consultaDTO = new ConsultaDTO(consultaEntity);
        return consultaDTO;
    }

    @Override
    public ConsultaDTO getById(int id) throws NotFoundException {
        return new ConsultaDTO(consultaRepository.findById(id).orElseThrow(() -> new NotFoundException("Consulta não encontrada com o id: " + id)));
    }

    @Override
    public List<ConsultaDTO> getAll() {
        List<ConsultaDTO> consultaDTOS = new ArrayList<>();

        for (ConsultaEntity consulta : consultaRepository.findAll()) {
            ConsultaDTO consultaDTO = new ConsultaDTO(consulta);
            consultaDTOS.add(consultaDTO);
        }

        return consultaDTOS;
    }

    @Override
    public String delete(int id) {
        consultaRepository.deleteById(id);
        return   "A consulta de id " + id + " foi deletada com sucesso";
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

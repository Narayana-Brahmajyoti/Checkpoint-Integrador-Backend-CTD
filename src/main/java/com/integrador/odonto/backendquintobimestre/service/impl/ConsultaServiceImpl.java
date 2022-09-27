package com.integrador.odonto.backendquintobimestre.service.impl;

import com.integrador.odonto.backendquintobimestre.entity.ConsultaEntity;
import com.integrador.odonto.backendquintobimestre.entity.DentistaEntity;
import com.integrador.odonto.backendquintobimestre.entity.PacienteEntity;
import com.integrador.odonto.backendquintobimestre.entity.dto.ConsultaDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.DentistaDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.EnderecoDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
import com.integrador.odonto.backendquintobimestre.exception.NotFoundException;
import com.integrador.odonto.backendquintobimestre.exception.UniqueIndexException;
import com.integrador.odonto.backendquintobimestre.repository.IConsultaRepository;
import com.integrador.odonto.backendquintobimestre.service.IClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @Autowired
    private EnderecoServiceImpl enderecoService;

    @Override
    public ConsultaDTO create(ConsultaDTO consultaDTO) throws NotFoundException, UniqueIndexException {
        ConsultaEntity consultaEntity = new ConsultaEntity(consultaDTO);
        PacienteDTO pacienteDTO;
        EnderecoDTO enderecoDTO;
        DentistaDTO dentistaDTO;

        int idPaciente = consultaDTO.getPaciente().getId();
        pacienteDTO = pacienteService.getById(idPaciente);
        int idEndereco = pacienteDTO.getEndereco().getId();
        enderecoDTO = enderecoService.getById(idEndereco);
        int idDentista = consultaDTO.getDentista().getId();
        dentistaDTO = dentistaService.getById(idDentista);

        LocalDateTime dataHoraConsulta = consultaDTO.getDataHoraConsulta();
        String dataHoraConsultaBD = String.valueOf(consultaRepository.findByDataHoraConsulta(dataHoraConsulta));

        if(pacienteService.ifPacienteExists(idPaciente) && dentistaService.ifDentistaExists(idDentista) && !dataHoraConsulta.equals(dataHoraConsultaBD))
            try {
                consultaEntity = new ConsultaEntity(consultaDTO, enderecoDTO, pacienteDTO, dentistaDTO);

                PacienteEntity paciente = new PacienteEntity(pacienteDTO, enderecoDTO);
                DentistaEntity dentista = new DentistaEntity(dentistaDTO);
                consultaEntity.setPaciente(paciente);
                consultaEntity.setDentista(dentista);
                consultaEntity = consultaRepository.save(consultaEntity);
            } catch (Exception ex){
                throw new UniqueIndexException("Consulta com data e hora: " + dataHoraConsulta.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + " já cadastrada no sistema");

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
    public String delete(int id) throws NotFoundException {
        try{
            consultaRepository.deleteById(id);
            return "Consulta de id " + id + " foi deletada";
        } catch (Exception ex){
            throw new NotFoundException("Não foi possível deletar consulta de id: " + id + ", id inexistente");
        }
    }

    @Override
    public ConsultaDTO update(ConsultaDTO consultaDTO, int id) throws NotFoundException {
        ConsultaEntity consultaEntity = consultaRepository.findById(id).orElseThrow(() -> new NotFoundException("Consulta não encontrado com o id: " + id));
        PacienteDTO pacienteDTO = pacienteService.getById(consultaDTO.getPaciente().getId());
        EnderecoDTO enderecoDTO = enderecoService.getById(pacienteDTO.getEndereco().getId());
        DentistaDTO dentistaDTO = dentistaService.getById(consultaDTO.getDentista().getId());

        consultaEntity = new ConsultaEntity(consultaDTO, enderecoDTO, pacienteDTO, dentistaDTO, id);

        consultaEntity.setPaciente(new PacienteEntity(pacienteDTO, enderecoDTO));
        consultaEntity.setDentista(new DentistaEntity(dentistaDTO));
        consultaEntity.setDataHoraConsulta(consultaDTO.getDataHoraConsulta());

        consultaEntity = consultaRepository.saveAndFlush(consultaEntity);

        ConsultaDTO consultaDTO1 = new ConsultaDTO(consultaEntity);

        return consultaDTO1;
    }

    public boolean ifConsultaExists(int id) {
        return consultaRepository.existsById(id);
    }

    public List<ConsultaDTO> getByPaciente(String nome){
        List<ConsultaEntity> consultas = consultaRepository.findByPaciente(nome);
        List<ConsultaDTO> consultaDTO = new ArrayList<>();
        for(ConsultaEntity consulta : consultas)
            consultaDTO.add(new ConsultaDTO(consulta));

        return consultaDTO;
    }

}

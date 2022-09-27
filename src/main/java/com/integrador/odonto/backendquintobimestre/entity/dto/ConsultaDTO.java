package com.integrador.odonto.backendquintobimestre.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.integrador.odonto.backendquintobimestre.entity.ConsultaEntity;
import com.integrador.odonto.backendquintobimestre.entity.DentistaEntity;
import com.integrador.odonto.backendquintobimestre.entity.PacienteEntity;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class ConsultaDTO {

    private int id;
    private PacienteDTO paciente;
    private DentistaDTO dentista;
//    private int idPaciente;
//    private int idDentista;
    private LocalDateTime dataHoraConsulta;
    //private Calendar dataHoraConsulta;



    public ConsultaDTO() {
    }

    public ConsultaDTO(ConsultaEntity consultaEntity) {
        this.id = consultaEntity.getId();
        this.paciente = new PacienteDTO(consultaEntity.getPaciente());
        this.dentista = new DentistaDTO(consultaEntity.getDentista());
//        this.idPaciente = consultaEntity.getPaciente().getId();
//        this.idDentista = consultaEntity.getDentista().getId();
        this.dataHoraConsulta = consultaEntity.getDataHoraConsulta();
    }

    public int getId() {
        return id;
    }

    public PacienteDTO getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDTO paciente) {
        this.paciente = paciente;
    }

    public DentistaDTO getDentista() {
        return dentista;
    }

    public void setDentista(DentistaDTO dentista) {
        this.dentista = dentista;
    }

    public LocalDateTime getDataHoraConsulta() {
        return dataHoraConsulta;
    }

    public void setDataHoraConsulta(LocalDateTime dataHoraConsulta) {
        this.dataHoraConsulta = dataHoraConsulta;
    }

    //    public Calendar getDataHoraConsulta() {
//        return dataHoraConsulta;
//    }
//
//    public void setDataHoraConsulta(Calendar dataHoraConsulta) {
//        this.dataHoraConsulta = dataHoraConsulta;
//    }

//	public int getIdPaciente() {
//		return idPaciente;
//	}
//
//	public void setIdPaciente(int idPaciente) {
//		this.idPaciente = idPaciente;
//	}
//
//	public int getIdDentista() {
//		return idDentista;
//	}
//
//	public void setIdDentista(int idDentista) {
//		this.idDentista = idDentista;
//	}
    
    
}
package com.integrador.odonto.backendquintobimestre.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.integrador.odonto.backendquintobimestre.entity.ConsultaEntity;
import com.integrador.odonto.backendquintobimestre.entity.DentistaEntity;
import com.integrador.odonto.backendquintobimestre.entity.PacienteEntity;

import java.util.Calendar;
import java.util.Date;

public class ConsultaDTO {

    private Integer id;
    private PacienteDTO paciente;
    private DentistaDTO dentista;
    private Calendar dataHoraConsulta;



    public ConsultaDTO() {
    }

    public ConsultaDTO(ConsultaEntity consultaEntity) {
        this.id = consultaEntity.getId();
        this.paciente = new PacienteDTO(consultaEntity.getPaciente());
        this.dentista = new DentistaDTO(consultaEntity.getDentista());
        this.dataHoraConsulta = consultaEntity.getDataHoraConsulta();
    }

    public Integer getId() {
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

    public Calendar getDataHoraConsulta() {
        return dataHoraConsulta;
    }

    public void setDataHoraConsulta(Calendar dataHoraConsulta) {
        this.dataHoraConsulta = dataHoraConsulta;
    }
}
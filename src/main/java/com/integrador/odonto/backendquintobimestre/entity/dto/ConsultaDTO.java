package com.integrador.odonto.backendquintobimestre.entity.dto;

import com.integrador.odonto.backendquintobimestre.entity.DentistaEntity;
import com.integrador.odonto.backendquintobimestre.entity.PacienteEntity;

import java.util.Date;

public class ConsultaDTO {

    private Integer id;
    private PacienteEntity paciente;
    private DentistaEntity dentista;
    private Date dataHouraConsulta;

    public ConsultaDTO() {
    }

    public Integer getId() {
        return id;
    }

    public PacienteEntity getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteEntity paciente) {
        this.paciente = paciente;
    }

    public DentistaEntity getDentista() {
        return dentista;
    }

    public void setDentista(DentistaEntity dentista) {
        this.dentista = dentista;
    }

    public Date getDataHouraConsulta() {
        return dataHouraConsulta;
    }

    public void setDataHouraConsulta(Date dataHouraConsulta) {
        this.dataHouraConsulta = dataHouraConsulta;
    }
}

package com.integrador.odonto.backendquintobimestre.entity;

import com.integrador.odonto.backendquintobimestre.entity.dto.ConsultaDTO;

import java.util.Date;

public class ConsultaEntity {
    private Integer id;
    private PacienteEntity paciente;
    private DentistaEntity dentista;
    private Date dataHouraConsulta;

    public Integer getId() {
        return id;
    }

    public ConsultaEntity(ConsultaDTO consultaDTO) {
        this.id = consultaDTO.getId();
        this.paciente = consultaDTO.getPaciente();
        this.dentista = consultaDTO.getDentista();
        this.dataHouraConsulta = consultaDTO.getDataHouraConsulta();
    }

    public ConsultaEntity() {
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

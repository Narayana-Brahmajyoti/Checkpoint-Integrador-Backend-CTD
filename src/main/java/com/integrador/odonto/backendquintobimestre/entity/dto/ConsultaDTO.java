package com.integrador.odonto.backendquintobimestre.entity.dto;

import com.integrador.odonto.backendquintobimestre.entity.ConsultaEntity;
import com.integrador.odonto.backendquintobimestre.entity.DentistaEntity;
import com.integrador.odonto.backendquintobimestre.entity.PacienteEntity;

import java.util.Date;

public class ConsultaDTO {

    private Integer id;
    private PacienteEntity paciente;
    private DentistaEntity dentista;
    private Date dataHoraConsulta;

    public ConsultaDTO(ConsultaEntity consultaEntity) {
        this.id = consultaEntity.getId();
        this.paciente = consultaEntity.getPaciente();
        this.dentista = consultaEntity.getDentista();
        this.dataHoraConsulta = consultaEntity.getDataHoraConsulta();
    }

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

    public Date getDataHoraConsulta() {
        return dataHoraConsulta;
    }

    public void setDataHoraConsulta(Date dataHoraConsulta) {
        this.dataHoraConsulta = dataHoraConsulta;
    }
}

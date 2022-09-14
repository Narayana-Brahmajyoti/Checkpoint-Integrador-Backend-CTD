package com.integrador.odonto.backendquintobimestre.entity;

import com.integrador.odonto.backendquintobimestre.entity.dto.ConsultaDTO;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "Consulta")
public class ConsultaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "idPaciente", referencedColumnName = "id")
    private PacienteEntity paciente;
    @OneToOne
    @JoinColumn(name = "idDentista", referencedColumnName = "id")
    private DentistaEntity dentista;
    @Column(nullable = false)
    private Date dataHoraConsulta;

    public Integer getId() {
        return id;
    }

    public ConsultaEntity(ConsultaDTO consultaDTO) {
        this.id = consultaDTO.getId();
        this.paciente = consultaDTO.getPaciente();
        this.dentista = consultaDTO.getDentista();
        this.dataHoraConsulta = consultaDTO.getDataHoraConsulta();
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

    public Date getDataHoraConsulta() {
        return dataHoraConsulta;
    }

    public void setDataHoraConsulta(Date dataHoraConsulta) {
        this.dataHoraConsulta = dataHoraConsulta;
    }
}

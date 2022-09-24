package com.integrador.odonto.backendquintobimestre.entity;

import com.integrador.odonto.backendquintobimestre.entity.dto.ConsultaDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.DentistaDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.EnderecoDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "Consulta")
public class ConsultaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@OneToOne
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "idPaciente")
    private PacienteEntity paciente;

    //@OneToOne
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "idDentista")
    private DentistaEntity dentista;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, unique = true)
    private Calendar dataHoraConsulta;

    public ConsultaEntity(ConsultaDTO consultaDTO, EnderecoDTO enderecoDTO, PacienteDTO pacienteDTO, DentistaDTO dentistaDTO) {
        this.id = consultaDTO.getId();
        this.paciente = new PacienteEntity(pacienteDTO, enderecoDTO);
        this.dentista = new DentistaEntity(dentistaDTO);
        this.dataHoraConsulta = consultaDTO.getDataHoraConsulta();
    }

    public ConsultaEntity() {
    }

    public ConsultaEntity(ConsultaDTO consultaDTO) {
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

    public Calendar getDataHoraConsulta() {
        return dataHoraConsulta;
    }

    public void setDataHoraConsulta(Calendar dataHoraConsulta) {
        this.dataHoraConsulta = dataHoraConsulta;
    }
}
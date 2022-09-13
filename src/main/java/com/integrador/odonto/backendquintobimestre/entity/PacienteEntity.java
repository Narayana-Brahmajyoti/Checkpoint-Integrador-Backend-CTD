package com.integrador.odonto.backendquintobimestre.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "PACIENTE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PacienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String sobreNome;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "idEndereco", referencedColumnName = "id")
    private EnderecoEntity enderecoEntity;
    @Column(nullable = false)
    private String rg;
    @Column(nullable = true)
    private LocalDate dataDeAlta;

    public PacienteEntity(int id, String nome, String sobreNome, EnderecoEntity enderecoEntity, String rg, LocalDate dataDeAlta) {
        this.id = id;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.enderecoEntity = enderecoEntity;
        this.rg = rg;
        this.dataDeAlta = dataDeAlta;
    }

    public PacienteEntity(PacienteDTO pacienteDTO) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public EnderecoEntity getEndereco() {
        return enderecoEntity;
    }

    public void setEndereco(EnderecoEntity enderecoEntity) {
        this.enderecoEntity = enderecoEntity;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDate getDataDeAlta() {
        return dataDeAlta;
    }

    public void setDataDeAlta(LocalDate dataDeAlta) {
        this.dataDeAlta = dataDeAlta;
    }
}

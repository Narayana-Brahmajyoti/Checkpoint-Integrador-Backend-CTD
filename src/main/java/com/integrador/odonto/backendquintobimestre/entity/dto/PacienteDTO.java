package com.integrador.odonto.backendquintobimestre.entity.dto;


import com.integrador.odonto.backendquintobimestre.entity.EnderecoEntity;
import com.integrador.odonto.backendquintobimestre.entity.PacienteEntity;

import java.time.LocalDate;

public class PacienteDTO {
    private String nome;
    private String sobreNome;
    private EnderecoEntity enderecoEntity;
    private String rg;
    private LocalDate dataDeAlta;

    public PacienteDTO(PacienteEntity pacienteEntity) {
        this.nome = pacienteEntity.getNome();
        this.sobreNome = pacienteEntity.getSobreNome();
        this.enderecoEntity = pacienteEntity.getEndereco();
        this.rg = pacienteEntity.getRg();
        this.dataDeAlta = pacienteEntity.getDataDeAlta();
    }

    public PacienteDTO() {

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

    public EnderecoEntity getEnderecoEntity() {
        return enderecoEntity;
    }

    public void setEnderecoEntity(EnderecoEntity enderecoEntity) {
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

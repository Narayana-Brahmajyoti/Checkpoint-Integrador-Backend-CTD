package com.integrador.odonto.backendquintobimestre.entity;

import java.time.LocalDate;

public class PacienteEntity {
    private int id;
    private String nome;
    private String sobreNome;
    private EnderecoEntity enderecoEntity;
    private String rg;
    private LocalDate dataDeAlta;

    public PacienteEntity(int id, String nome, String sobreNome, EnderecoEntity enderecoEntity, String rg, LocalDate dataDeAlta) {
        this.id = id;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.enderecoEntity = enderecoEntity;
        this.rg = rg;
        this.dataDeAlta = dataDeAlta;
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

package com.integrador.odonto.backendquintobimestre.entity;

import com.integrador.odonto.backendquintobimestre.entity.dto.DentistaDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.EnderecoDTO;

public class DentistaEntity {
    private int id;
    private String nome;
    private String SobreNome;
    private String matricula;

    public DentistaEntity(int id, String nome, String sobreNome, String matricula) {
        this.id = id;
        this.nome = nome;
        this.SobreNome = sobreNome;
        this.matricula = matricula;
    }

    public DentistaEntity(DentistaDTO dentistaDTO) {

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
        return SobreNome;
    }

    public void setSobreNome(String sobreNome) {
        SobreNome = sobreNome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}

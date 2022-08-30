package com.integrador.odonto.backendquintobimestre.entity.dto;

import com.integrador.odonto.backendquintobimestre.entity.DentistaEntity;

public class DentistaDTO {
    private String nome;
    private String SobreNome;
    private String matricula;

    public DentistaDTO(DentistaEntity dentista) {
        this.nome = dentista.getNome();
        SobreNome = dentista.getSobreNome();
        this.matricula = dentista.getMatricula();
    }

    public DentistaDTO() {
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

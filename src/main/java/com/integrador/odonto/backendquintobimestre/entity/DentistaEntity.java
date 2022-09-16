package com.integrador.odonto.backendquintobimestre.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.integrador.odonto.backendquintobimestre.entity.dto.DentistaDTO;


import javax.persistence.*;

@Entity
@Table(name = "Dentista")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DentistaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //@Column (name="id", nullable = false)
    private int id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String sobreNome;
    @Column(nullable = false)
    private String matricula;

    public DentistaEntity() {
    }

    public DentistaEntity(int id, String nome, String sobreNome, String matricula) {
        this.id = id;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.matricula = matricula;
    }

    public DentistaEntity(DentistaDTO dentistaDTO) {
        this.id = dentistaDTO.getId();
        this.nome = dentistaDTO.getNome();
        this.sobreNome = dentistaDTO.getSobreNome();;
        this.matricula = dentistaDTO.getMatricula();;

    }

    public int getId() {
        return id;
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
        sobreNome = sobreNome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}

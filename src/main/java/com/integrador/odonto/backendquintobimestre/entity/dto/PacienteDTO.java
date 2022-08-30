package main.java.com.integrador.odonto.backendquintobimestre.entity.dto;

import main.java.com.integrador.odonto.backendquintobimestre.entity.EnderecoEntity;
import main.java.com.integrador.odonto.backendquintobimestre.entity.PacienteEntity;

import java.time.LocalDate;

public class PacienteDTO {
    private String nome;
    private String sobreNome;
    private EnderecoEntity enderecoEntity;
    private String rg;
    private LocalDate dataDeAlta;

    public PacienteDTO(PacienteEntity paciente) {
        this.nome = paciente.getNome();
        this.sobreNome = paciente.getSobreNome();
        this.enderecoEntity = paciente.getEndereco();
        this.rg = paciente.getRg();
        this.dataDeAlta = paciente.getDataDeAlta();
    }



}

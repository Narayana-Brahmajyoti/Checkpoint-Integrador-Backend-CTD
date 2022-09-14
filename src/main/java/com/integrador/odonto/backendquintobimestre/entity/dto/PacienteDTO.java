package com.integrador.odonto.backendquintobimestre.entity.dto;

import com.integrador.odonto.backendquintobimestre.entity.EnderecoEntity;
import com.integrador.odonto.backendquintobimestre.entity.PacienteEntity;

public class PacienteDTO {

	private Integer id;
    private String nome;
    private String sobreNome;
    private EnderecoEntity endereco;
    private String rg;
    private String dataDeAlta;

    public PacienteDTO(PacienteEntity paciente) {
        this.nome = paciente.getNome();
        this.sobreNome = paciente.getSobreNome();
        this.endereco = paciente.getEndereco();
        this.rg = paciente.getRg();
        this.dataDeAlta = paciente.getDataDeAlta();
    }
    
    public PacienteDTO() {
    }

	public Integer getId() {
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
		this.sobreNome = sobreNome;
	}

	public EnderecoEntity getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoEntity endereco) {
		this.endereco = endereco;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getDataDeAlta() {
		return dataDeAlta;
	}

	public void setDataDeAlta(String dataDeAlta) {
		this.dataDeAlta = dataDeAlta;
	}
}

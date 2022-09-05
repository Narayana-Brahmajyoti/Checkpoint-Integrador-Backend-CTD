package com.integrador.odonto.backendquintobimestre.entity.dto;


import com.integrador.odonto.backendquintobimestre.entity.EnderecoEntity;
import com.integrador.odonto.backendquintobimestre.entity.PacienteEntity;

public class PacienteDTO {
    private String nome;
    private String sobreNome;
    private EnderecoEntity enderecoEntity;
    private String rg;
    private String dataDeAlta;

    public PacienteDTO(PacienteEntity paciente) {
        this.nome = paciente.getNome();
        this.sobreNome = paciente.getSobreNome();
        this.enderecoEntity.setId(paciente.getEndereco());
        this.rg = paciente.getRg();
        this.dataDeAlta = paciente.getDataDeAlta();
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

	public String getDataDeAlta() {
		return dataDeAlta;
	}

	public void setDataDeAlta(String dataDeAlta) {
		this.dataDeAlta = dataDeAlta;
	}
}

package com.integrador.odonto.backendquintobimestre.entity.dto;

import com.integrador.odonto.backendquintobimestre.entity.PacienteEntity;
import com.integrador.odonto.backendquintobimestre.entity.dto.EnderecoDTO;

public class PacienteDTO {
	private int id;
	private String nome;
	private String sobreNome;
	private EnderecoDTO endereco;
	private String rg;
	private String dataDeAlta;

	public PacienteDTO() {
	}

	public PacienteDTO(PacienteEntity paciente) {
		this.id = paciente.getId();
		this.nome = paciente.getNome();
		this.sobreNome = paciente.getSobreNome();
		this.endereco = new EnderecoDTO(paciente.getEnderecoEntity());
		this.rg = paciente.getRg();
		this.dataDeAlta = paciente.getDataDeAlta();
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

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
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

package com.integrador.odonto.backendquintobimestre.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;

import javax.persistence.*;

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

		@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		@JoinColumn(name = "idEndereco", referencedColumnName = "id")
		private EnderecoEntity enderecoEntity;
		
		@Column(nullable = false)
		private String rg;
		@Column(nullable = true)
		private String dataDeAlta;
		
		public PacienteEntity() {
			
		}
		
		public PacienteEntity(PacienteDTO pacienteDTO) {
			this.id = pacienteDTO.getId();
			this.nome = pacienteDTO.getNome();
			this.sobreNome = pacienteDTO.getSobreNome();
			this.enderecoEntity = new EnderecoEntity(pacienteDTO.getEndereco());
			this.rg = pacienteDTO.getRg();
			this.dataDeAlta = pacienteDTO.getDataDeAlta();
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

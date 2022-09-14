package com.integrador.odonto.backendquintobimestre.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;

import javax.persistence.*;

@Entity
@Table(name = "Paciente")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PacienteEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String sobreNome;
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "idEndereco", referencedColumnName = "id")
	private EnderecoEntity endereco;
	@Column(nullable = false)
	private String rg;
	@Column(nullable = true)
	private String dataDeAlta;


    public PacienteEntity(Integer id, String nome, String sobreNome, EnderecoEntity  endereco, String rg, String dataDeAlta) {
        this.id = id;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.endereco = endereco;
        this.rg = rg;
        this.dataDeAlta = dataDeAlta;
    }
    
    public PacienteEntity(PacienteDTO pacienteDTO) {

    }
    
    public PacienteEntity() {
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

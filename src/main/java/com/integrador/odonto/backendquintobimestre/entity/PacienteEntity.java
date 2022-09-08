package com.integrador.odonto.backendquintobimestre.entity;

<<<<<<< HEAD
import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;

public class PacienteEntity {
    private Integer id;
=======
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "PACIENTE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PacienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
>>>>>>> diego
    private String nome;
    @Column(nullable = false)
    private String sobreNome;
<<<<<<< HEAD
    private Integer endereco;
    private String rg;
    private String dataDeAlta;
=======
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "idEndereco", referencedColumnName = "id")
    private EnderecoEntity enderecoEntity;
    @Column(nullable = false)
    private String rg;
    @Column(nullable = true)
    private LocalDate dataDeAlta;
>>>>>>> diego

    public PacienteEntity(Integer id, String nome, String sobreNome, Integer endereco, String rg, String dataDeAlta) {
        this.id = id;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.endereco = endereco;
        this.rg = rg;
        this.dataDeAlta = dataDeAlta;
    }
    
    public PacienteEntity(PacienteDTO paciente) {
        this.nome = paciente.getNome();
        this.sobreNome = paciente.getSobreNome();
        this.endereco = paciente.getEndereco();
        this.rg = paciente.getRg();
        this.dataDeAlta = paciente.getDataDeAlta();
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

	public Integer getEndereco() {
		return endereco;
	}

	public void setEndereco(Integer endereco) {
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

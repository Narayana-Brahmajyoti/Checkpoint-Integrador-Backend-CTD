package com.integrador.odonto.backendquintobimestre.entity;

import com.integrador.odonto.backendquintobimestre.entity.dto.EnderecoDTO;
import javax.persistence.*;

@Entity
@Table(name = "ENDERECO")
public class EnderecoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String rua;
    @Column(nullable = false)
    private String numero;
    @Column(nullable = false)
    private String complemento;
    @Column(nullable = false)
    private String bairro;

    public EnderecoEntity() {

    }

    public EnderecoEntity(EnderecoDTO enderecoDTO) {
        this.id = enderecoDTO.getId();
        this.rua = enderecoDTO.getRua();
        this.numero = enderecoDTO.getNumero();
        this.complemento = enderecoDTO.getComplemento();
        this.bairro = enderecoDTO.getBairro();
    }


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}

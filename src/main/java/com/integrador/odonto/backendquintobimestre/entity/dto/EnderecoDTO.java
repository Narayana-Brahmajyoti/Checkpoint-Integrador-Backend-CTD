package com.integrador.odonto.backendquintobimestre.entity.dto;

import com.integrador.odonto.backendquintobimestre.entity.EnderecoEntity;

public class EnderecoDTO {
    private Integer id;
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;

    public EnderecoDTO(EnderecoEntity enderecoEntity) {
    	this.id = enderecoEntity.getId();
        this.rua = enderecoEntity.getRua();
        this.numero = enderecoEntity.getNumero();
        this.complemento = enderecoEntity.getComplemento();
        this.bairro = enderecoEntity.getBairro();
    }

    public EnderecoDTO() {
    }

    public Integer getId() {
        return id;
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

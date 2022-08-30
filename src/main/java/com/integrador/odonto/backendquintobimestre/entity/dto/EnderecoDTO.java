package main.java.com.integrador.odonto.backendquintobimestre.entity.dto;

import main.java.com.integrador.odonto.backendquintobimestre.entity.EnderecoEntity;

public class EnderecoDTO {
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;

    public EnderecoDTO(EnderecoEntity endereco) {
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.complemento = endereco.getComplemento();
        this.bairro = endereco.getBairro();
    }

    public EnderecoDTO() {
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

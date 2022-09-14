package com.integrador.odonto.backendquintobimestre.validation;

import com.integrador.odonto.backendquintobimestre.entity.dto.DentistaDTO;

public class ValidationDentista {

    public String validationDentistaVariables(DentistaDTO dentistaDTO) {
        if (dentistaDTO.getNome() == null) {
            return "Nome nao preenchido";
        } else if (dentistaDTO.getSobreNome() == null) {
            return "Sobrenome nao preenchido";
        } else if (dentistaDTO.getMatricula() == null){
            return "Matricula nao preenchida";
        }
        return null;
    }
}

package com.integrador.odonto.backendquintobimestre.validation;

import com.integrador.odonto.backendquintobimestre.entity.dto.DentistaDTO;
import com.integrador.odonto.backendquintobimestre.exception.VariableNullException;

import java.util.ArrayList;
import java.util.List;

public class ValidationDentista {

    public Boolean validationDentistaVariables(DentistaDTO dentistaDTO) throws VariableNullException {
        List<String> variables = new ArrayList<>();
        if (dentistaDTO.getNome() == null || dentistaDTO.getNome().isEmpty()) {
            variables.add("nome");
        } if (dentistaDTO.getSobreNome() == null || dentistaDTO.getSobreNome().isEmpty()) {
            variables.add("sobreNome");
        } if (dentistaDTO.getMatricula() == null || dentistaDTO.getMatricula().isEmpty()){
            variables.add("matrícula");
        } if(!variables.isEmpty())
            throw new VariableNullException("Verifique as variáveis listadas", variables);

        return true;

    }
}

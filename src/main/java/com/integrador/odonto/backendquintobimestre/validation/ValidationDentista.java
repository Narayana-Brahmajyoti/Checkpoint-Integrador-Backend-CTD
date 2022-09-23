package com.integrador.odonto.backendquintobimestre.validation;

import com.integrador.odonto.backendquintobimestre.entity.dto.DentistaDTO;
import com.integrador.odonto.backendquintobimestre.exception.VariableNullException;

import java.util.ArrayList;
import java.util.List;

public class ValidationDentista {

    public Boolean validationDentistaVariables(DentistaDTO dentistaDTO) throws VariableNullException {
        List<String> variables = new ArrayList<>();
        if (dentistaDTO.getNome() == null || dentistaDTO.getNome().trim().isEmpty()) {
            variables.add("Nome");
        }
        if (dentistaDTO.getSobreNome() == null || dentistaDTO.getSobreNome().trim().isEmpty()) {
            variables.add("SobreNome");
        }
        if (dentistaDTO.getMatricula() == null || dentistaDTO.getMatricula().trim().isEmpty()){
            variables.add("Matrícula");
        }
        if(!variables.isEmpty())
            throw new VariableNullException("Verifique as variáveis listadas", variables);

        return true;

    }
}

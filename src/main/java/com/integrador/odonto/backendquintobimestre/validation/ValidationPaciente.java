package com.integrador.odonto.backendquintobimestre.validation;

import java.util.ArrayList;
import java.util.List;

import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
import com.integrador.odonto.backendquintobimestre.exception.VariableNullException;

public class ValidationPaciente {

    public Boolean validationPacienteVariables(PacienteDTO pacienteDTO) throws VariableNullException {
        List<String> variables = new ArrayList<>();

        if (pacienteDTO.getNome()== null || pacienteDTO.getNome().isEmpty()) {
            variables.add("nome");
        }
        if (pacienteDTO.getSobreNome()== null || pacienteDTO.getSobreNome().isEmpty()) {
            variables.add("sobreNome");
        }
        if (pacienteDTO.getRg()== null || pacienteDTO.getRg().isEmpty()) {
            variables.add("rg");
        }
    	
        if(!variables.isEmpty())
            throw new VariableNullException("Verifique as variáveis listadas", variables);

        return true;
    }

}

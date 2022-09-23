package com.integrador.odonto.backendquintobimestre.validation;

import java.util.ArrayList;
import java.util.List;

import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
import com.integrador.odonto.backendquintobimestre.exception.VariableNullException;

public class ValidationPaciente {

    public Boolean validationPacienteVariables(PacienteDTO pacienteDTO) throws VariableNullException {
        List<String> variables = new ArrayList<>();

        if (pacienteDTO.getNome() == null || pacienteDTO.getNome().trim().isEmpty()) {
            variables.add("Nome");
        }
        if (pacienteDTO.getSobreNome() == null || pacienteDTO.getSobreNome().trim().isEmpty()) {
            variables.add("SobreNome");
        }
        if (pacienteDTO.getEndereco() == null || pacienteDTO.getEndereco().getId() <= 0) {
            variables.add("Endereço");
        }
        if (pacienteDTO.getRg() == null || pacienteDTO.getRg().trim().isEmpty()) {
            variables.add("RG");
        }
        if (pacienteDTO.getDataDeAlta() == null || pacienteDTO.getDataDeAlta().trim().isEmpty()) {
            variables.add("Data de alta");
        }
    	
        if(!variables.isEmpty())
            throw new VariableNullException("Verifique as variáveis listadas", variables);

        return true;
    }

}

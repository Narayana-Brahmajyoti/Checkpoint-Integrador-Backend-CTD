package com.integrador.odonto.backendquintobimestre.validation;

import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;

public class ValidationPaciente {

    public String validationPacienteVariables(PacienteDTO pacienteDTO) {
        if (pacienteDTO.getNome() == null){
            return "Nome do paciente não pode ser nulo";
        } else if (pacienteDTO.getSobreNome() == null ) {
            return "Sobrenome do paciente não pode ser nulo";
        }

        return null;
    }

}

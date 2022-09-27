package com.integrador.odonto.backendquintobimestre.validation;

import com.integrador.odonto.backendquintobimestre.entity.dto.ConsultaDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
import com.integrador.odonto.backendquintobimestre.exception.VariableNullException;

import java.util.ArrayList;
import java.util.List;

public class ValidationConsulta {
    public Boolean validationConsultaVariables(ConsultaDTO consultaDTO) throws VariableNullException {
        List<String> variables = new ArrayList<>();

        if (consultaDTO.getPaciente().getId() <= 0 ) {
            variables.add("Paciente");
        }
        if (consultaDTO.getDentista().getId() <= 0) {
            variables.add("Dentista");
        }
        if (consultaDTO.getDataHoraConsulta() == null ) {
            variables.add("Data/hora consulta");
        }
        if (!variables.isEmpty())
            throw new VariableNullException("Verifique as variáveis listadas", variables);

        return true;
    }

}
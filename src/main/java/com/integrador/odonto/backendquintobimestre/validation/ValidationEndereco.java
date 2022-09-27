package com.integrador.odonto.backendquintobimestre.validation;

import com.integrador.odonto.backendquintobimestre.entity.dto.EnderecoDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
import com.integrador.odonto.backendquintobimestre.exception.VariableNullException;

import java.util.ArrayList;
import java.util.List;

public class ValidationEndereco {

    public Boolean validationEnderecoVariables(EnderecoDTO enderecoDTO) throws VariableNullException {
        List<String> variables = new ArrayList<>();

        if (enderecoDTO.getRua() == null || enderecoDTO.getRua().trim().isEmpty()) {
            variables.add("Rua");
        }
        if (enderecoDTO.getNumero() == null || enderecoDTO.getNumero().trim().isEmpty()) {
            variables.add("Numero");
        }
        if (enderecoDTO.getBairro() == null || enderecoDTO.getBairro().trim().isEmpty()) {
            variables.add("Bairro");
        }

        if(!variables.isEmpty())
            throw new VariableNullException("Verifique as variáveis listadas", variables);

        return true;
    }

}

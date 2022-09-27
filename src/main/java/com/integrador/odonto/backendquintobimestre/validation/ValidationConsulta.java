package com.integrador.odonto.backendquintobimestre.validation;

import com.integrador.odonto.backendquintobimestre.entity.dto.ConsultaDTO;
import com.integrador.odonto.backendquintobimestre.exception.VariableNullException;
import com.integrador.odonto.backendquintobimestre.repository.IConsultaRepository;
import com.integrador.odonto.backendquintobimestre.repository.IDentistaRepository;
import com.integrador.odonto.backendquintobimestre.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ValidationConsulta {

    private static final int minimoMinutoConsulta = 15;
    private static final int maximoMinutoConsulta = 60;
    private static final String dataRegexp = "^[0-9]{2}\\/[0-9]{2}\\/[0-9]{4} [0-9]{2}:[0-9]{2}:[0-9]{2}$";

    @Autowired
    IPacienteRepository pacienteRepository;

    @Autowired
    IDentistaRepository dentistaRepository;

    @Autowired
    IConsultaRepository consultaRepository;

    public ValidationConsulta() {
    }

     public String validationPaciente(int id) {
        if (!pacienteRepository.existsById(id)) {
            return "Paciente inválido";
        }
        return null;
    }

    public String validationDentista(int id) {
        if (!dentistaRepository.existsById(id)) {
            return "Dentista inválido";
        }
        return null;
    }

    public String validationData (Long id, String inicio, String fim){

        if(!(isValid(inicio, dataRegexp) && isValid(fim, dataRegexp))
        ) {
            return "A Data de início ou de fim  está no formato incorreto [Formato correto: dd/MM/yyyy HH:mm:ss]";
        }
        LocalDateTime inicioTime = LocalDateTime.parse(inicio, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        LocalDateTime fimTime = LocalDateTime.parse(fim, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        if(fimTime.isAfter(inicioTime)){
            return "A data fim não pode ser inferior a de inicial";
        } else if (fimTime.until(inicioTime, ChronoUnit.MINUTES) < minimoMinutoConsulta) {
            return "A duração da consulta é inferior ao tempo mínimo permitido";
        } else if (fimTime.until(inicioTime, ChronoUnit.MINUTES) > maximoMinutoConsulta) {
            return "A duração da consulta é superior ao tempo máximo permitido";
        } else if (!consultaRepository.getByConsultaData(id,inicioTime,fimTime).isEmpty()) {
            return "Este período de tempo está ocupado";
        }
        return null;
    }

    public boolean isValid(String texto, String regexp){
        Pattern pattern = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(texto);
        return matcher.find();
    }

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
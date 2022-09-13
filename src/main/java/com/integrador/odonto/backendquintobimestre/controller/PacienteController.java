package com.integrador.odonto.backendquintobimestre.controller;

import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
import com.integrador.odonto.backendquintobimestre.service.impl.PacienteServiceImpl;
import com.integrador.odonto.backendquintobimestre.validation.ValidationPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Paciente")
public class PacienteController {

    @Autowired
    private PacienteServiceImpl pacienteService;

    private ValidationPaciente validationPaciente = new ValidationPaciente();

    @PostMapping
    public ResponseEntity<PacienteDTO> create(@RequestBody PacienteDTO pacienteDTO){
        ResponseEntity responseEntity = null;

        String erro = validationPaciente.validationPacienteVariables(pacienteDTO);

        if (erro == null){
            PacienteDTO pacienteDTO1 = (pacienteService.create(pacienteDTO));
            responseEntity = new ResponseEntity<>(pacienteDTO1, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);

        }
        return responseEntity;
    }

    @GetMapping
    public List<PacienteDTO> getAll(){
        return pacienteService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> getById(@PathVariable int id){
        ResponseEntity responseEntity = null;
        PacienteDTO pacienteDTO = pacienteService.getById(id);

        if (pacienteDTO != null){
            responseEntity = new ResponseEntity<>(pacienteDTO, HttpStatus.OK);
        } else {

        }


    }

















}

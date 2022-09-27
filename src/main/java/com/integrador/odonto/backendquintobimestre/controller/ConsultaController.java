package com.integrador.odonto.backendquintobimestre.controller;

import com.integrador.odonto.backendquintobimestre.entity.dto.ConsultaDTO;
import com.integrador.odonto.backendquintobimestre.exception.NotFoundException;
import com.integrador.odonto.backendquintobimestre.exception.UniqueIndexException;
import com.integrador.odonto.backendquintobimestre.exception.VariableNullException;
import com.integrador.odonto.backendquintobimestre.service.impl.ConsultaServiceImpl;
import com.integrador.odonto.backendquintobimestre.validation.ValidationConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaServiceImpl consultaService;

    ValidationConsulta validationConsulta = new ValidationConsulta();

    @PostMapping("/create")
    public ResponseEntity<ConsultaDTO> create (@RequestBody ConsultaDTO consultaDTO) throws NotFoundException, VariableNullException, UniqueIndexException {
        ResponseEntity responseEntity = null;

        Boolean erro = validationConsulta.validationConsultaVariables(consultaDTO);

        if (erro){
            ConsultaDTO consultaDTO1 = consultaService.create(consultaDTO);
            responseEntity = new ResponseEntity<>(consultaDTO1, HttpStatus.OK);
        }

        return responseEntity;

    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ConsultaDTO> getById(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(consultaService.getById(id), HttpStatus.OK);

    }

    @GetMapping("/getAll")
    public List<ConsultaDTO> getAll() {
        return consultaService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) throws NotFoundException {
        return consultaService.delete(id);
    }

    @PutMapping("/update/{id}")
    public ConsultaDTO update(@PathVariable int id, @RequestBody ConsultaDTO consultaDTO) throws NotFoundException, UniqueIndexException {
        return consultaService.update(consultaDTO, id);
    }

    @GetMapping("/getByPaciente")
    public List<ConsultaDTO> getByPaciente(@RequestParam(value = "name") String name){
        return consultaService.getByPaciente(name);
    }




}
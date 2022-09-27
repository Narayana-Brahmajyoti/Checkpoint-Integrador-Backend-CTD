package com.integrador.odonto.backendquintobimestre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.integrador.odonto.backendquintobimestre.exception.NotFoundException;
import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
import com.integrador.odonto.backendquintobimestre.exception.VariableNullException;
import com.integrador.odonto.backendquintobimestre.service.impl.PacienteServiceImpl;
import com.integrador.odonto.backendquintobimestre.validation.ValidationPaciente;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private PacienteServiceImpl pacienteService;
    
    ValidationPaciente validationPaciente = new ValidationPaciente();

    @PostMapping("/create")
    public ResponseEntity<PacienteDTO> create(@RequestBody PacienteDTO pacienteDTO) throws VariableNullException, NotFoundException {
        ResponseEntity responseEntity = null;

        Boolean erro = validationPaciente.validationPacienteVariables(pacienteDTO);
        
        if (erro) {
        	PacienteDTO pacienteDTO1 = pacienteService.create(pacienteDTO);
            responseEntity = new ResponseEntity<>(pacienteDTO1, HttpStatus.OK);
        }

        return responseEntity;
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<PacienteDTO> getById(@PathVariable int id) throws NotFoundException {
    	return new ResponseEntity<>(pacienteService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<PacienteDTO> getAll() {
        return pacienteService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) throws NotFoundException {
        return pacienteService.delete(id);
    }

    @PutMapping("/update/{id}")
    public PacienteDTO update(@RequestBody PacienteDTO pacienteDTO, @PathVariable int id) throws NotFoundException {
        return pacienteService.update(pacienteDTO, id);
    }

    @GetMapping("/getByName")
    public List<PacienteDTO> getByName(@RequestParam(value = "nome") String nome ) {
        return pacienteService.getByName(nome);
    }

    @GetMapping("/getBySurname")
    public List<PacienteDTO> getBySurname(@RequestParam(value = "sobrenome") String sobrenome ) {
        return pacienteService.getBySurname(sobrenome);
    }

    @GetMapping("/getByRg")
    public List<PacienteDTO> getByRg(@RequestParam(value = "rg") String rg ) {
        return pacienteService.getByRg(rg);
    }

    @GetMapping("/getByDataDeAlta")
    public List<PacienteDTO> getByDataDeAlta(@RequestParam(value = "dataDeAlta") String dataDeAlta ) {
        return pacienteService.getByDataDeAlta(dataDeAlta);
    }

}
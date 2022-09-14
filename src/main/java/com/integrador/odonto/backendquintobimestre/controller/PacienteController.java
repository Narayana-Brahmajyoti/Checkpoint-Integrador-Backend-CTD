package com.integrador.odonto.backendquintobimestre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
import com.integrador.odonto.backendquintobimestre.service.impl.PacienteServiceImpl;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private PacienteServiceImpl pacienteService;

    @PostMapping
    public ResponseEntity<PacienteDTO> create(@RequestBody PacienteDTO pacienteDTO) {
        ResponseEntity responseEntity = null;
        
    	if(pacienteDTO.getNome() != null){
    		PacienteDTO enderecoDTO2 = pacienteService.create(pacienteDTO);
            responseEntity = new ResponseEntity<>(enderecoDTO2, HttpStatus.OK);
    	}
    	else
    	{
            responseEntity = new ResponseEntity<>("Nome não preenchido", HttpStatus.BAD_REQUEST);
    	}
    	
    	return responseEntity;
    }

    @GetMapping("/{id}")
    public PacienteDTO getById(@PathVariable int id) {
        return pacienteService.getById(id);
    }
    
    @GetMapping
    public List<PacienteDTO> getAll() {
        return pacienteService.getAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return pacienteService.delete(id);
    }

    @PutMapping("/{id}")
    public PacienteDTO update(@RequestBody PacienteDTO pacienteDTO, @PathVariable int id) {
        return pacienteService.update(pacienteDTO, id);
    }

}

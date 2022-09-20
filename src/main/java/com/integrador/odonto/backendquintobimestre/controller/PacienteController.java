package com.integrador.odonto.backendquintobimestre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
import com.integrador.odonto.backendquintobimestre.service.impl.PacienteServiceImpl;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private PacienteServiceImpl pacienteService;

    @PostMapping("/create")
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

    @GetMapping("/getById/{id}")
    public PacienteDTO getById(@PathVariable int id) {
        return pacienteService.getById(id);
    }

    @GetMapping("/getAll")
    public List<PacienteDTO> getAll() {
        return pacienteService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        return pacienteService.delete(id);
    }

    @PutMapping("/update/{id}")
    public PacienteDTO update(@RequestBody PacienteDTO pacienteDTO, @PathVariable int id) {
        return pacienteService.update(pacienteDTO, id);
    }

    @GetMapping("/getByName")
    public PacienteDTO getByName(@RequestParam(value = "nome") String nome ) {
        return pacienteService.getByName(nome);
    }


}

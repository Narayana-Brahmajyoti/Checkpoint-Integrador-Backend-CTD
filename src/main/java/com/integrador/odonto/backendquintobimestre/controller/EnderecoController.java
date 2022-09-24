package com.integrador.odonto.backendquintobimestre.controller;

import java.util.List;

import com.integrador.odonto.backendquintobimestre.exception.NotFoundException;
import com.integrador.odonto.backendquintobimestre.exception.VariableNullException;
import com.integrador.odonto.backendquintobimestre.validation.ValidationEndereco;
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

import com.integrador.odonto.backendquintobimestre.entity.dto.EnderecoDTO;
import com.integrador.odonto.backendquintobimestre.service.impl.EnderecoServiceImpl;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoServiceImpl enderecoService;

    ValidationEndereco validationEndereco = new ValidationEndereco();
    @PostMapping("/create")
    public ResponseEntity<EnderecoDTO> create(@RequestBody EnderecoDTO enderecoDTO) throws VariableNullException {
        ResponseEntity responseEntity = null;

        Boolean erro = validationEndereco.validationEnderecoVariables(enderecoDTO);
        
    	if(erro){
    		EnderecoDTO enderecoDTO2 = enderecoService.create(enderecoDTO);
            responseEntity = new ResponseEntity<>(enderecoDTO2, HttpStatus.OK);
    	}
    	
    	return responseEntity;
    }

    @GetMapping("/getById/{id}")
    public EnderecoDTO getById(@PathVariable int id) throws NotFoundException {
        return enderecoService.getById(id);
    }
    
    @GetMapping("/getAll")
    public List<EnderecoDTO> getAll() {
        return enderecoService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) throws NotFoundException {
        return enderecoService.delete(id);
    }

    @PutMapping("/update/{id}")
    public EnderecoDTO update(@RequestBody EnderecoDTO enderecoDTO, @PathVariable int id) throws NotFoundException {
        return enderecoService.update(enderecoDTO, id);
    }


}

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

import com.integrador.odonto.backendquintobimestre.entity.dto.EnderecoDTO;
import com.integrador.odonto.backendquintobimestre.service.impl.EnderecoServiceImpl;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoServiceImpl enderecoService;

    @PostMapping("/create")
    public ResponseEntity<EnderecoDTO> create(@RequestBody EnderecoDTO enderecoDTO) {
        ResponseEntity responseEntity = null;
        
    	if(enderecoDTO.getRua() != null){
    		EnderecoDTO enderecoDTO2 = enderecoService.create(enderecoDTO);
            responseEntity = new ResponseEntity<>(enderecoDTO2, HttpStatus.OK);
    	}
    	else
    	{
            responseEntity = new ResponseEntity<>("Rua não preenchida", HttpStatus.BAD_REQUEST);
    	}
    	
    	return responseEntity;
    }

    @GetMapping("/getById/{id}")
    public EnderecoDTO getById(@PathVariable int id) {
        return enderecoService.getById(id);
    }
    
    @GetMapping("/getAll")
    public List<EnderecoDTO> getAll() {
        return enderecoService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        return enderecoService.delete(id);
    }

    @PutMapping("/update/{id}")
    public EnderecoDTO update(@RequestBody EnderecoDTO enderecoDTO, @PathVariable int id) {
        return enderecoService.update(enderecoDTO, id);
    }


}

package com.integrador.odonto.backendquintobimestre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public EnderecoDTO create(@RequestBody EnderecoDTO enderecoDTO) {
        return enderecoService.create(enderecoDTO);
    }

    @GetMapping("/{id}")
    public EnderecoDTO getById(@PathVariable int id) {
        return enderecoService.getById(id);
    }
    
    @GetMapping
    public List<EnderecoDTO> getAll() {
        return enderecoService.getAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {

        return enderecoService.delete(id);
    }

    @PutMapping("/{id}")
    public EnderecoDTO update(@RequestBody EnderecoDTO enderecoDTO, @PathVariable int id) {
        return enderecoService.update(enderecoDTO, id);
    }
}

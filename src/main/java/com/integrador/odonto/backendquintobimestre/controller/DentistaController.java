package com.integrador.odonto.backendquintobimestre.controller;


import com.integrador.odonto.backendquintobimestre.entity.dto.DentistaDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
import com.integrador.odonto.backendquintobimestre.service.impl.DentistaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentista")
public class DentistaController {

    @Autowired
    private DentistaServiceImpl dentistaService;

    @PostMapping
    public ResponseEntity<DentistaDTO> create (@RequestBody DentistaDTO dentistaDTO) {
        ResponseEntity responseEntity = null;
        if (dentistaDTO.getNome() != null) {
            DentistaDTO dentistaDTO1 = dentistaService.create(dentistaDTO);
            responseEntity = new ResponseEntity<>(dentistaDTO1, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>("Dentista nao criado", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DentistaDTO> getById(@PathVariable int id) {
        ResponseEntity responseEntity = null;
        DentistaDTO dentistaDTO = dentistaService.getById(id);
        if(dentistaDTO != null){
            responseEntity = new ResponseEntity<>(dentistaDTO, HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<>("Id nao localizado", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @PutMapping("/{id}")
    public DentistaDTO update (@RequestBody DentistaDTO dentistaDTO, @PathVariable int id) {
        return dentistaService.update(dentistaDTO, id);
    }

    @GetMapping
    public List<DentistaDTO> getAll() {
        return dentistaService.getAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return dentistaService.delete(id);
    }
}

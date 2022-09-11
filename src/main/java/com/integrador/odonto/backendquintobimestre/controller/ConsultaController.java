package com.integrador.odonto.backendquintobimestre.controller;

import com.integrador.odonto.backendquintobimestre.entity.dto.ConsultaDTO;
import com.integrador.odonto.backendquintobimestre.service.impl.ConsultaServiceImpl;
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
    @PostMapping
    public ResponseEntity<ConsultaDTO> create (@RequestBody ConsultaDTO consultaDTO) {
        ResponseEntity responseEntity = null;
        if (consultaDTO.getPaciente() != null && consultaDTO.getDentista() != null) {
            ConsultaDTO consultaDTO1 = consultaService.create(consultaDTO);
            responseEntity = new ResponseEntity<>(consultaDTO1, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>("Consulta não criada", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @GetMapping("/{id}")
    public ConsultaDTO getById(@PathVariable int id) {
        return consultaService.getById(id);
    }

    @GetMapping
    public List<ConsultaDTO> getAll() {
        return consultaService.getAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return consultaService.delete(id);
    }

    @PutMapping("/{id}")
    public ConsultaDTO update(@RequestBody ConsultaDTO consultaDTO, @PathVariable Integer id) {
        return consultaService.update(consultaDTO, id);
    }


}

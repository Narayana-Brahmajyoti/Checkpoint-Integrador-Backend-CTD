package com.integrador.odonto.backendquintobimestre.controller;

import com.integrador.odonto.backendquintobimestre.entity.dto.ConsultaDTO;
import com.integrador.odonto.backendquintobimestre.exception.NotFoundException;
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


    @PostMapping("/create")
    public ResponseEntity<ConsultaDTO> create (@RequestBody ConsultaDTO consultaDTO) throws NotFoundException{
        ResponseEntity responseEntity = null;


        if (consultaDTO.getDataHoraConsulta() != null ){
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
    public ConsultaDTO update(@PathVariable int id, @RequestBody ConsultaDTO consultaDTO) throws NotFoundException {
        return consultaService.update(consultaDTO, id);
    }

    @GetMapping("/getByPaciente")
    public ConsultaDTO getByPaciente(@RequestParam(value = "name") String name){
        return consultaService.getByPaciente(name);
    }




}

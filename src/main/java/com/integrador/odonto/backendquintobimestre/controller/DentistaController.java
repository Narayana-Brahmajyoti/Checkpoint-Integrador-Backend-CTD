package com.integrador.odonto.backendquintobimestre.controller;


import com.integrador.odonto.backendquintobimestre.entity.dto.DentistaDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
import com.integrador.odonto.backendquintobimestre.exception.NotFoundException;
import com.integrador.odonto.backendquintobimestre.service.impl.DentistaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/dentista")
public class DentistaController {

    @Autowired
    private DentistaServiceImpl dentistaService;

    @PostMapping("/create")
    @Transactional
    public ResponseEntity<DentistaDTO> create (@RequestBody DentistaDTO dentistaDTO) throws NotFoundException {
        ResponseEntity responseEntity = null;
        if (dentistaDTO.getNome() != null) {
            DentistaDTO dentistaDTO1 = dentistaService.create(dentistaDTO);
            responseEntity = new ResponseEntity<>(dentistaDTO1, HttpStatus.OK);
        } else {
            responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dentista nao criado");
        }
        return responseEntity;
    }


    @GetMapping("/getById/{id}")
    public ResponseEntity<DentistaDTO> getById(@PathVariable int id) throws NotFoundException {
        ResponseEntity responseEntity = null;
        DentistaDTO dentistaDTO = dentistaService.getById(id);
        if(dentistaDTO != null){
            responseEntity = ResponseEntity.status(HttpStatus.OK).body(dentistaDTO);
        }else{
            responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dentista não encontrado");
        }
        return responseEntity;
    }

    @PutMapping("/update/{id}")
    @Transactional
    public DentistaDTO update (@RequestBody DentistaDTO dentistaDTO, @PathVariable int id) {
        return dentistaService.update(dentistaDTO, id);
    }

    @GetMapping("/getAll")
    public List<DentistaDTO> getAll() {
        return dentistaService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        return dentistaService.delete(id);
    }
}

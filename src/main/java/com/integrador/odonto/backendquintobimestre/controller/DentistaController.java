package com.integrador.odonto.backendquintobimestre.controller;


import com.integrador.odonto.backendquintobimestre.entity.dto.DentistaDTO;
import com.integrador.odonto.backendquintobimestre.service.impl.DentistaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            responseEntity = new ResponseEntity<>("Tiile não preenchido", HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }

    @GetMapping
    public DentistaDTO getById(@PathVariable int id) { return dentistaService.getById(id); }
}

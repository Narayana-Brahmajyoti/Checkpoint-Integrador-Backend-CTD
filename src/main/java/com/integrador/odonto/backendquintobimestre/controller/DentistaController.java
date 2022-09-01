package com.integrador.odonto.backendquintobimestre.controller;


import com.integrador.odonto.backendquintobimestre.entity.dto.DentistaDTO;
import com.integrador.odonto.backendquintobimestre.service.impl.DentistaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dentista")
public class DentistaController {

    @Autowired
    private DentistaServiceImpl dentistaService;

    @PostMapping
    public DentistaDTO create(@RequestBody DentistaDTO dentistaDTO) { return dentistaService.create(dentistaDTO);}

    @GetMapping
    public DentistaDTO getById(@PathVariable int id) { return dentistaService.getById(id); }
}

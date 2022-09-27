package com.integrador.odonto.backendquintobimestre.controller;


import com.integrador.odonto.backendquintobimestre.entity.dto.DentistaDTO;
import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
import com.integrador.odonto.backendquintobimestre.exception.NotFoundException;
import com.integrador.odonto.backendquintobimestre.exception.UniqueIndexException;
import com.integrador.odonto.backendquintobimestre.exception.VariableNullException;
import com.integrador.odonto.backendquintobimestre.service.impl.DentistaServiceImpl;
import com.integrador.odonto.backendquintobimestre.validation.ValidationDentista;
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

    ValidationDentista validationDentista = new ValidationDentista();
    @PostMapping("/create")
    public ResponseEntity<DentistaDTO> create (@RequestBody DentistaDTO dentistaDTO) throws VariableNullException, UniqueIndexException {
        ResponseEntity responseEntity = null;

        Boolean erro = validationDentista.validationDentistaVariables(dentistaDTO);

        if (erro) {
            DentistaDTO dentistaDTO1 = dentistaService.create(dentistaDTO);
            responseEntity = new ResponseEntity<>(dentistaDTO1, HttpStatus.OK);
        }

        return responseEntity;
    }


    @GetMapping("/getById/{id}")
    public ResponseEntity<DentistaDTO> getById(@PathVariable int id) throws NotFoundException {
        ResponseEntity responseEntity = null;
        DentistaDTO dentistaDTO = dentistaService.getById(id);
        if(dentistaDTO != null){
            responseEntity = new ResponseEntity<>(dentistaDTO, HttpStatus.OK);
        }else{
            //responseEntity = new ResponseEntity<>("Id nao localizado", HttpStatus.NOT_FOUND);
            responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dentista não encontrado");
        }
        return responseEntity;
    }

    @PutMapping("/update/{id}")
    public DentistaDTO update (@RequestBody DentistaDTO dentistaDTO, @PathVariable int id) throws NotFoundException {
        return dentistaService.update(dentistaDTO, id);
    }

    @GetMapping("/getAll")
    public List<DentistaDTO> getAll() {
        return dentistaService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) throws NotFoundException {
        return dentistaService.delete(id);
    }
}

package com.integrador.odonto.backendquintobimestre.controller;

import com.integrador.odonto.backendquintobimestre.entity.dto.UserDTO;
import com.integrador.odonto.backendquintobimestre.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody UserDTO userDTO) {
        Boolean create = userService.create(userDTO);

        if (create)
            return new ResponseEntity<>("Usuário criado com sucesso!", HttpStatus.CREATED);

        return new ResponseEntity<>("Usuário não pode ser criado!", HttpStatus.CONFLICT);
    }
}

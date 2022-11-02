package com.ericksena.cursospringbootalgaworks.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ericksena.cursospringbootalgaworks.domain.model.Entrega;
import com.ericksena.cursospringbootalgaworks.domain.service.EntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega criarEntrega(@RequestBody Entrega entrega){
        return entregaService.solicitar(entrega);
    }

}

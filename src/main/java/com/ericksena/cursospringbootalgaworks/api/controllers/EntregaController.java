package com.ericksena.cursospringbootalgaworks.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ericksena.cursospringbootalgaworks.domain.model.Entrega;
import com.ericksena.cursospringbootalgaworks.domain.repository.EntregaRepository;
import com.ericksena.cursospringbootalgaworks.domain.service.EntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private EntregaRepository entregaRepository;
    @Autowired
    private EntregaService entregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega criarEntrega(@Valid @RequestBody Entrega entrega) {
        return entregaService.solicitar(entrega);
    }

    @GetMapping
    public List<Entrega> listar() {
        return entregaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrega> buscar(@PathVariable("id") Long entregaId) {
        return entregaRepository.findById(entregaId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}

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

import com.ericksena.cursospringbootalgaworks.api.assembler.EntregaAssembler;
import com.ericksena.cursospringbootalgaworks.api.model.EntregaModel;
import com.ericksena.cursospringbootalgaworks.api.model.input.EntregaInput;
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
    @Autowired
    private EntregaAssembler entregaAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaModel criarEntrega(@Valid @RequestBody EntregaInput entregaInput) {
        Entrega novaEntrega = entregaAssembler.toEntity(entregaInput);
        Entrega entregaSolicitada = entregaService.solicitar(novaEntrega);
        return entregaAssembler.toModel(entregaSolicitada);
    }

    @GetMapping
    public List<EntregaModel> listar() {
        return entregaAssembler.toCollectionModel(entregaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregaModel> buscar(@PathVariable("id") Long entregaId) {
        return entregaRepository.findById(entregaId)
                .map(entrega -> {
                    return ResponseEntity.ok(entregaAssembler.toModel(entrega));
                })
                .orElse(ResponseEntity.notFound().build());
    }

}

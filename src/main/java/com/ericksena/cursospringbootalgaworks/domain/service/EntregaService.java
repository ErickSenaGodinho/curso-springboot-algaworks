package com.ericksena.cursospringbootalgaworks.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ericksena.cursospringbootalgaworks.domain.model.Cliente;
import com.ericksena.cursospringbootalgaworks.domain.model.Entrega;
import com.ericksena.cursospringbootalgaworks.domain.model.StatusEntrega;
import com.ericksena.cursospringbootalgaworks.domain.repository.EntregaRepository;

@Service
public class EntregaService {

    @Autowired
    private EntregaRepository entregaRepository;
    @Autowired
    private ClienteService clienteService;

    @Transactional
    public Entrega solicitar(Entrega entrega) {
        Cliente cliente = clienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());

        return entregaRepository.save(entrega);
    }
}

package com.ericksena.cursospringbootalgaworks.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ericksena.cursospringbootalgaworks.domain.exception.NegocioException;
import com.ericksena.cursospringbootalgaworks.domain.model.Cliente;
import com.ericksena.cursospringbootalgaworks.domain.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente salvar(Cliente cliente) {
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
                .stream()
                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
                if(emailEmUso){
                    throw new NegocioException("Email já está em uso.");
                }
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }
}

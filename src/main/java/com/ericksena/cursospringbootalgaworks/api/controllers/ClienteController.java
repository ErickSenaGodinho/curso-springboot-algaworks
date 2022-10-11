package com.ericksena.cursospringbootalgaworks.api.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ericksena.cursospringbootalgaworks.domain.model.Cliente;

@RestController
public class ClienteController {

    @GetMapping("/clientes")
    public List<Cliente> listar() {
        var cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("Joao");
        cliente1.setEmail("joao123@gmail.com");
        cliente1.setTelefone("(33) 91234-5678");
        
        var cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Maria");
        cliente2.setEmail("maria123@hotmail.com");
        cliente2.setTelefone("(33) 99876-5432");

        return Arrays.asList(cliente1, cliente2);
    }
}

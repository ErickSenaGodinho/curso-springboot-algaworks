package com.ericksena.cursospringbootalgaworks.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Destinatario {

    @Column(name = "destinatario_nome", nullable = false, length = 60)
    private String nome;

    @Column(name = "destinatario_logradouro", nullable = false)
    private String logradouro;

    @Column(name = "destinatario_numero", nullable = false, length = 30)
    private String numero;

    @Column(name = "destinatario_complemento", nullable = false, length = 60)
    private String complemento;

    @Column(name = "destinatario_bairro",nullable = false, length = 30)
    private String bairro;
}

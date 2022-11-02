package com.ericksena.cursospringbootalgaworks.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Destinatario {

    @NotBlank
    @Column(name = "destinatario_nome", nullable = false, length = 60)
    private String nome;

    @NotBlank
    @Column(name = "destinatario_logradouro", nullable = false)
    private String logradouro;

    @NotBlank
    @Column(name = "destinatario_numero", nullable = false, length = 30)
    private String numero;

    @NotBlank
    @Column(name = "destinatario_complemento", nullable = false, length = 60)
    private String complemento;

    @NotBlank
    @Column(name = "destinatario_bairro", nullable = false, length = 30)
    private String bairro;
}

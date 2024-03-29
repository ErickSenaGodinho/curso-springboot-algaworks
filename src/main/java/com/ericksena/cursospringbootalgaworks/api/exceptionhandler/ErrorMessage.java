package com.ericksena.cursospringbootalgaworks.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class ErrorMessage {
    private Integer status;
    private OffsetDateTime dateTime;
    private String title;
    private List<Field> fields;
}

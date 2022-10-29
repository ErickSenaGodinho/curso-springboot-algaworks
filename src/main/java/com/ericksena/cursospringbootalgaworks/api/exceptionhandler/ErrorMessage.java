package com.ericksena.cursospringbootalgaworks.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessage {
    private Integer status;
    private LocalDateTime dateTime;
    private String title;
    private List<Field> fields;
}

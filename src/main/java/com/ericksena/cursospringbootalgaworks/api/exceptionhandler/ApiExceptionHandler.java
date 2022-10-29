package com.ericksena.cursospringbootalgaworks.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ericksena.cursospringbootalgaworks.domain.exception.NegocioException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<Field> fields = new ArrayList<>();

        ex.getBindingResult().getAllErrors().forEach(objectError -> {
            String name = ((FieldError) objectError).getField();
            String message = messageSource.getMessage(objectError, LocaleContextHolder.getLocale());
            fields.add(new Field(name, message));
        });

        ErrorMessage errorMessage = instantiateErrorMassage(status, "Um ou mais campos estão inválidos", fields);

        return handleExceptionInternal(ex, errorMessage, headers, status, request);
    }

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<Object> handleNegocioException(NegocioException ex, WebRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorMessage errorMessage = instantiateErrorMassage(status, ex.getMessage(), null);

        return handleExceptionInternal(ex, errorMessage, new HttpHeaders(), status, request);
    }

    private final ErrorMessage instantiateErrorMassage(HttpStatus status, String title, List<Field> fields) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setStatus(status.value());
        errorMessage.setDateTime(LocalDateTime.now());
        errorMessage.setTitle(title);
        errorMessage.setFields(fields);
        return errorMessage;
    }
}

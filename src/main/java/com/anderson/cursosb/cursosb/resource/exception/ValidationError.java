package com.anderson.cursosb.cursosb.resource.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * ValidationError
 */
public class ValidationError extends StandardError{
    private static final long serialVersionUID = 1L;

    private List<FieldErrors> errors = new ArrayList<>();

    public ValidationError(Integer status, String msg, Long timestamp) {
        super(status, msg, timestamp);
    }

    public List<FieldErrors> getErrors() {
        return errors;
    }

    public void addError(String nome, String erro) {
        FieldErrors error = new FieldErrors(nome, erro);
        this.errors.add(error);
    }
}
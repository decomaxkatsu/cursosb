package com.anderson.cursosb.cursosb.services.exceptions;

import org.springframework.dao.DataIntegrityViolationException;

/**
 * IntegrityViolationException
 */
public class IntegrityViolationException extends DataIntegrityViolationException{

    private static final long serialVersionUID = 1L;

    public IntegrityViolationException(String msg) {
        super(msg);
    }

    public IntegrityViolationException(String msg, Throwable cause) {
        super(msg, cause);
    }    
}
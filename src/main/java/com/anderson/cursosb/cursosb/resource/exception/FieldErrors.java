package com.anderson.cursosb.cursosb.resource.exception;

import java.io.Serializable;

/**
 * FielErrors
 */
public class FieldErrors implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String nome;
    private String erro;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public FieldErrors(){}

    public FieldErrors(String nome, String erro) {
        this.nome = nome;
        this.erro = erro;
    }
    
}
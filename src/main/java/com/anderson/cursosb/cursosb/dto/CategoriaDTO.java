package com.anderson.cursosb.cursosb.dto;

import java.io.Serializable;

import com.anderson.cursosb.cursosb.domain.Categoria;

/**
 * CategoriaDTO
 */
public class CategoriaDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;

    public CategoriaDTO(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CategoriaDTO(){}

    public CategoriaDTO(Categoria categoria){
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
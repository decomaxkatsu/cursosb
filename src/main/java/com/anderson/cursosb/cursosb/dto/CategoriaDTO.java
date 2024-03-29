package com.anderson.cursosb.cursosb.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.anderson.cursosb.cursosb.domain.Categoria;

import org.hibernate.validator.constraints.Length;

/**
 * CategoriaDTO
 */
public class CategoriaDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer id;
    
    @NotEmpty(message = "O Campo nome não pode ser nulo!")
    @Length(min = 5, max = 80, message = "O campo nome deve ter entre 5 e 80 caracteres!")
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
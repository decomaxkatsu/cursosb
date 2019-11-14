package com.anderson.cursosb.cursosb.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.anderson.cursosb.cursosb.domain.Cliente;

import org.hibernate.validator.constraints.Length;

/**
 * ClienteDTO
 */
public class ClienteDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "O campo nome deve ser preenchido!")
    @Length(min=5, max = 120, message = "O campo nome deve conter entre 5 e 120 caracteres!")
    private String nome;

    @Email(message = "E-mail inválido!")
    @NotEmpty(message = "O campo email deve ser preenchido!")
    private String email;

    public ClienteDTO(){}

    public ClienteDTO(Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
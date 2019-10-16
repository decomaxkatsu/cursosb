package com.anderson.cursosb.cursosb.services;

import java.util.Optional;

import com.anderson.cursosb.cursosb.domain.Categoria;
import com.anderson.cursosb.cursosb.repository.CategoriaRepository;
import com.anderson.cursosb.cursosb.services.Exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CategoriaService
 */
@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscar(Integer id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.orElseThrow(() -> new ObjectNotFoundException(
            "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }
}
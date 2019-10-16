package com.anderson.cursosb.cursosb.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anderson.cursosb.cursosb.domain.Categoria;
import com.anderson.cursosb.cursosb.services.CategoriaService;

/**
 * CategoriaResource
 */
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
    
    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Categoria categoria = categoriaService.buscar(id);      

        return ResponseEntity.ok().body(categoria);
    }
}
package com.anderson.cursosb.cursosb.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * CategoriaResource
 */
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
    
    @RequestMapping(method = RequestMethod.GET)
    public String listar() {
        return "Está furunfando";    
    }
}
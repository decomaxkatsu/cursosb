package com.anderson.cursosb.cursosb.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.anderson.cursosb.cursosb.domain.Categoria;
import com.anderson.cursosb.cursosb.dto.CategoriaDTO;
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
        Categoria categoria = categoriaService.find(id);      

        return ResponseEntity.ok().body(categoria);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<CategoriaDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page, 
            @RequestParam(value = "size", defaultValue = "24") Integer size, 
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy){
        Page<CategoriaDTO> categorias = categoriaService.findAll(page, size, direction, orderBy);
        return ResponseEntity.ok().body(categorias);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaDTO categoriaDTO){
        Categoria categoria = categoriaService.fromDTO(categoriaDTO);
        categoria = categoriaService.insert(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody CategoriaDTO categoriaDTO){
        Categoria categoria = categoriaService.fromDTO(categoriaDTO);
        categoriaService.update(id, categoria);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
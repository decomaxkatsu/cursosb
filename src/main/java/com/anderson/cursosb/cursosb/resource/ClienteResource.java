package com.anderson.cursosb.cursosb.resource;

import javax.validation.Valid;

import com.anderson.cursosb.cursosb.domain.Cliente;
import com.anderson.cursosb.cursosb.dto.ClienteDTO;
import com.anderson.cursosb.cursosb.services.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClienteResource
 */
@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
    
    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id){
        Cliente cliente = clienteService.find(id);

        return ResponseEntity.ok().body(cliente);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<ClienteDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page, 
            @RequestParam(value = "size", defaultValue = "24") Integer size, 
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy){
        Page<ClienteDTO> categorias = clienteService.findAll(page, size, direction, orderBy);
        return ResponseEntity.ok().body(categorias);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody ClienteDTO clienteDTO){
        Cliente cliente = clienteService.fromDTO(clienteDTO);
        clienteService.update(id, cliente);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
package com.anderson.cursosb.cursosb.resource;

import com.anderson.cursosb.cursosb.domain.Pedido;
import com.anderson.cursosb.cursosb.services.PedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PedidoResource
 */
@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    @RequestMapping(value = "/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id){
        Pedido pedido = pedidoService.buscar(id);

        return ResponseEntity.ok().body(pedido);
    }    
}
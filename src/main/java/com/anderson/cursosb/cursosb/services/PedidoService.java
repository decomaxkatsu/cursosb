package com.anderson.cursosb.cursosb.services;

import java.util.Optional;

import com.anderson.cursosb.cursosb.domain.Pedido;
import com.anderson.cursosb.cursosb.repository.PedidoRepository;
import com.anderson.cursosb.cursosb.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PedidoService
 */
@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido buscar(Integer id){
        Optional<Pedido> pedido = pedidoRepository.findById(id);

        return pedido.orElseThrow(() -> 
            new ObjectNotFoundException("Nenhum registro encontrado para o Id: " + id));
    } 
    
}
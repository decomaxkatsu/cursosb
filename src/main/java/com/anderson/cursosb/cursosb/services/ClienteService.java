package com.anderson.cursosb.cursosb.services;

import java.util.Optional;

import com.anderson.cursosb.cursosb.domain.Cliente;
import com.anderson.cursosb.cursosb.repository.ClienteRepository;
import com.anderson.cursosb.cursosb.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClienteService
 */
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscar(Integer id){
        Optional<Cliente> cOptional = clienteRepository.findById(id);
        
        return cOptional.orElseThrow(() -> new ObjectNotFoundException(
            "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }
}
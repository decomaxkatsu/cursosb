package com.anderson.cursosb.cursosb.services;

import java.util.Optional;

import com.anderson.cursosb.cursosb.domain.Cliente;
import com.anderson.cursosb.cursosb.dto.ClienteDTO;
import com.anderson.cursosb.cursosb.repository.ClienteRepository;
import com.anderson.cursosb.cursosb.services.exceptions.IntegrityViolationException;
import com.anderson.cursosb.cursosb.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

/**
 * ClienteService
 */
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente find(Integer id){
        Optional<Cliente> cOptional = clienteRepository.findById(id);
        
        return cOptional.orElseThrow(() -> new ObjectNotFoundException(
            "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

    public Page<ClienteDTO> findAll(Integer page, Integer size, String direction, String orderBy){
        PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), orderBy);
        Page<ClienteDTO> clientesDTO = clienteRepository.findAll(pageRequest).map(obj -> new ClienteDTO(obj));
        return clientesDTO;
    }

    public void update(Integer id, Cliente cliente){
        Cliente cliente2 = find(id);
        clienteRepository.save(updateData(cliente2, cliente));
    }

    public void delete(Integer id){
        find(id);
        try{
            clienteRepository.deleteById(id);
        } catch(DataIntegrityViolationException e) {
            throw new IntegrityViolationException("Não é possível apagar um cliente que contenha pedidos", e);
        }
    }

	public Cliente fromDTO(ClienteDTO clienteDTO) {
        return new Cliente(clienteDTO.getId(), clienteDTO.getNome(), clienteDTO.getEmail(), null, null);
    }
    
    private Cliente updateData(Cliente newObj, Cliente obj){
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
        return newObj;
    }
}
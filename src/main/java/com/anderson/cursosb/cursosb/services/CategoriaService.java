package com.anderson.cursosb.cursosb.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.anderson.cursosb.cursosb.domain.Categoria;
import com.anderson.cursosb.cursosb.dto.CategoriaDTO;
import com.anderson.cursosb.cursosb.repository.CategoriaRepository;
import com.anderson.cursosb.cursosb.services.exceptions.ObjectNotFoundException;
import com.anderson.cursosb.cursosb.services.exceptions.IntegrityViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

/**
 * CategoriaService
 */
@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria find(Integer id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.orElseThrow(() -> new ObjectNotFoundException(
            "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public List<CategoriaDTO> findAll(){
        List<CategoriaDTO> categorias = categoriaRepository.findAll()
            .stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
        return categorias;
    }

    public Categoria insert(Categoria categoria){
        categoria.setId(null);
        return categoriaRepository.save(categoria);
    }

    public void update(Integer id, Categoria categoria){
        find(id);
        categoria.setId(id);
        categoriaRepository.save(categoria);
    }

    public void delete(Integer id){
        find(id);
        try{
            categoriaRepository.deleteById(id);
        } catch(DataIntegrityViolationException e) {
            throw new IntegrityViolationException("Não é possível apagar uma categoria que contenha produtos", e);
        }
    }
}
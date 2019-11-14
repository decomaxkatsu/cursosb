package com.anderson.cursosb.cursosb.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.anderson.cursosb.cursosb.domain.Categoria;
import com.anderson.cursosb.cursosb.dto.CategoriaDTO;
import com.anderson.cursosb.cursosb.repository.CategoriaRepository;
import com.anderson.cursosb.cursosb.services.exceptions.ObjectNotFoundException;
import com.anderson.cursosb.cursosb.services.exceptions.IntegrityViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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

    public Page<CategoriaDTO> findAll(Integer page, Integer size, String direction, String orderBy){
        PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), orderBy);
        Page<CategoriaDTO> categoriasDTO = categoriaRepository.findAll(pageRequest).map(obj -> new CategoriaDTO(obj));
        return categoriasDTO;
    }

    public Categoria insert(Categoria categoria){
        categoria.setId(null);
        return categoriaRepository.save(categoria);
    }

    public void update(Integer id, Categoria categoria){
        Categoria categoria2 = find(id);
        categoriaRepository.save(updateData(categoria2, categoria));
    }

    public void delete(Integer id){
        find(id);
        try{
            categoriaRepository.deleteById(id);
        } catch(DataIntegrityViolationException e) {
            throw new IntegrityViolationException("Não é possível apagar uma categoria que contenha produtos", e);
        }
    }

	public Categoria fromDTO(CategoriaDTO categoriaDTO) {
        return new Categoria(categoriaDTO.getId(), categoriaDTO.getNome());
    }
    
    private Categoria updateData(Categoria newObj, Categoria obj){
        newObj.setNome(obj.getNome());
        return newObj;
    }
}
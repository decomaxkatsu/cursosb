package com.anderson.cursosb.cursosb.repository;

import com.anderson.cursosb.cursosb.domain.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CategoriaRepository
 */
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

    
}
package com.anderson.cursosb.cursosb.repository;

import com.anderson.cursosb.cursosb.domain.Cidade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CidadeRepository
 */
@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

    
}
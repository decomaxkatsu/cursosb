package com.anderson.cursosb.cursosb.repository;

import com.anderson.cursosb.cursosb.domain.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ProdutoRepository
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

    
}
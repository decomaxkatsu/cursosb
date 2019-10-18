package com.anderson.cursosb.cursosb.repository;

import com.anderson.cursosb.cursosb.domain.Endereco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * EnderecoRepository
 */
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

    
}
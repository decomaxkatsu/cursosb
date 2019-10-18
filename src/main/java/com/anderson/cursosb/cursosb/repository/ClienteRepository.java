package com.anderson.cursosb.cursosb.repository;

import com.anderson.cursosb.cursosb.domain.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ClienteRepository
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

    
}
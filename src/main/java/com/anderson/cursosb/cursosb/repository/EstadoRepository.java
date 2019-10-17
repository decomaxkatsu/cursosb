package com.anderson.cursosb.cursosb.repository;

import com.anderson.cursosb.cursosb.domain.Estado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * EstadoRepository
 */
@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

    
}
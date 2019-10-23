package com.anderson.cursosb.cursosb.repository;

import com.anderson.cursosb.cursosb.domain.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * PedidoRepository
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

    
}
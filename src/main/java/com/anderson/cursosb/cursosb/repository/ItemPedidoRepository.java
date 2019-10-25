package com.anderson.cursosb.cursosb.repository;

import com.anderson.cursosb.cursosb.domain.ItemPedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer>{

    
}
package com.anderson.cursosb.cursosb.domain;

import javax.persistence.Entity;

import com.anderson.cursosb.cursosb.domain.enums.EstadoPagamento;

/**
 * PagamentoComCartao
 */
@Entity
public class PagamentoComCartao extends Pagamento {

    private static final long serialVersionUID = 1L;

    private Integer numeroParcelas;

    public PagamentoComCartao(Integer id, EstadoPagamento estadoPagto, Integer numeroParcelas, Pedido pedido) {
        super(id, estadoPagto, pedido);
        this.numeroParcelas = numeroParcelas;
    }

    public PagamentoComCartao() {
    }

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }
}
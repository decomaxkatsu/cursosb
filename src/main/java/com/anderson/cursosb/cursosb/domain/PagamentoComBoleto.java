package com.anderson.cursosb.cursosb.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.anderson.cursosb.cursosb.domain.enums.EstadoPagamento;

/**
 * PagamentoComBoleto
 */
@Entity
public class PagamentoComBoleto extends Pagamento {

    private static final long serialVersionUID = 1L;

    private Date dataPagamento;
    private Date dataVendcimento;

    public PagamentoComBoleto(Integer id, EstadoPagamento estadoPagto, Date dataPagamento, Date dataVendcimento, Pedido pedido) {
        super(id, estadoPagto, pedido);
        this.dataPagamento = dataPagamento;
        this.dataVendcimento = dataVendcimento;
    }

    public PagamentoComBoleto() {
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVendcimento() {
        return dataVendcimento;
    }

    public void setDataVendcimento(Date dataVendcimento) {
        this.dataVendcimento = dataVendcimento;
    }
}
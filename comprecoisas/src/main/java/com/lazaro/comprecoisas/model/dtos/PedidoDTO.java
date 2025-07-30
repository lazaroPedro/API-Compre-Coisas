package com.lazaro.comprecoisas.model.dtos;

import com.lazaro.comprecoisas.model.enums.StatusPedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;


public class PedidoDTO {

    private Long id;

    private LocalDateTime dataPedido;

    private StatusPedido statusPedido;
    @NotNull
    private Long comprador;

    @NotNull
    private EntregaDTO entrega;

    @NotNull
    private PagamentoDTO pagamento;

    @NotNull
    private List<Long> produtos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public Long getComprador() {
        return comprador;
    }

    public void setComprador(Long comprador) {
        this.comprador = comprador;
    }

    public EntregaDTO getEntrega() {
        return entrega;
    }

    public void setEntrega(EntregaDTO entrega) {
        this.entrega = entrega;
    }

    public PagamentoDTO getPagamento() {
        return pagamento;
    }

    public void setPagamento(PagamentoDTO pagamento) {
        this.pagamento = pagamento;
    }

    public List<Long> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Long> produtos) {
        this.produtos = produtos;
    }

    public PedidoDTO() {
    }
}

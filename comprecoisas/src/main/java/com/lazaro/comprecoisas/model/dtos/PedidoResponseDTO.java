package com.lazaro.comprecoisas.model.dtos;

import com.lazaro.comprecoisas.model.enums.StatusPedido;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;


public class PedidoResponseDTO {

    private Long id;

    private LocalDateTime dataPedido;

    private StatusPedido statusPedido;
    @NotNull
    private Long comprador;

    @NotNull
    private EntregaResponseDTO entrega;

    @NotNull
    private PagamentoResponseDTO pagamento;

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

    public EntregaResponseDTO getEntrega() {
        return entrega;
    }

    public void setEntrega(EntregaResponseDTO entrega) {
        this.entrega = entrega;
    }

    public PagamentoResponseDTO getPagamento() {
        return pagamento;
    }

    public void setPagamento(PagamentoResponseDTO pagamento) {
        this.pagamento = pagamento;
    }

    public List<Long> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Long> produtos) {
        this.produtos = produtos;
    }

    public PedidoResponseDTO() {
    }
}

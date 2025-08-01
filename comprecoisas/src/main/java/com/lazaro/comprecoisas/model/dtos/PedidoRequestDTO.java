package com.lazaro.comprecoisas.model.dtos;

import com.lazaro.comprecoisas.model.enums.StatusPedido;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;


public class PedidoRequestDTO {


    @NotNull
    private Long comprador;

    @NotNull
    private EntregaRequestDTO entrega;

    @NotNull
    private PagamentoRequestDTO pagamento;

    @NotEmpty
    private List<Long> produtos;


    public Long getComprador() {
        return comprador;
    }

    public void setComprador(Long comprador) {
        this.comprador = comprador;
    }

    public EntregaRequestDTO getEntrega() {
        return entrega;
    }

    public void setEntrega(EntregaRequestDTO entrega) {
        this.entrega = entrega;
    }

    public PagamentoRequestDTO getPagamento() {
        return pagamento;
    }

    public void setPagamento(PagamentoRequestDTO pagamento) {
        this.pagamento = pagamento;
    }

    public List<Long> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Long> produtos) {
        this.produtos = produtos;
    }

    public PedidoRequestDTO() {
    }
}

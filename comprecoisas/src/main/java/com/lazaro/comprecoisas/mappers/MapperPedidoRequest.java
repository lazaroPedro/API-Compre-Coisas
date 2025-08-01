package com.lazaro.comprecoisas.mappers;

import com.lazaro.comprecoisas.model.Pedido;
import com.lazaro.comprecoisas.model.Produto;
import com.lazaro.comprecoisas.model.dtos.PedidoRequestDTO;

public class MapperPedidoRequest {
    public static Pedido toEntity(PedidoRequestDTO pedido) {
        Pedido pedidoRetorno = new Pedido();
        pedidoRetorno.setEntrega(MapperEntregaRequest.toEntity(pedido.getEntrega()));
        pedidoRetorno.setPagamento(MapperPagamentoRequest.toEntity(pedido.getPagamento()));
        return pedidoRetorno;
    }
    public static PedidoRequestDTO toDTO(Pedido pedido) {
        PedidoRequestDTO pedidoRetorno = new PedidoRequestDTO();
        pedidoRetorno.setProdutos(pedido.getProdutos().stream().map(Produto::getId).toList());
        pedidoRetorno.setComprador(pedido.getComprador().getId());
        pedidoRetorno.setEntrega(MapperEntregaRequest.toDTO(pedido.getEntrega()));
        pedidoRetorno.setPagamento(MapperPagamentoRequest.toDTO(pedido.getPagamento()));
        return pedidoRetorno;
    }
}

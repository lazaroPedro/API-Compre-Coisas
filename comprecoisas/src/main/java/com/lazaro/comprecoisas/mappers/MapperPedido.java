package com.lazaro.comprecoisas.mappers;

import com.lazaro.comprecoisas.model.Pedido;
import com.lazaro.comprecoisas.model.Produto;
import com.lazaro.comprecoisas.model.dtos.PedidoDTO;

public class MapperPedido {
    public static Pedido toEntity(PedidoDTO pedido) {
        Pedido pedidoRetorno = new Pedido();
        pedidoRetorno.setId(pedido.getId());
        pedidoRetorno.setDataPedido(pedido.getDataPedido());
        pedidoRetorno.setStatusPedido(pedido.getStatusPedido());
        pedidoRetorno.setEntrega(MapperEntrega.toEntity(pedido.getEntrega()));
        pedidoRetorno.setPagamento(MapperPagamento.toEntity(pedido.getPagamento()));
        // Mapper entrega
        // Mapper pagamento

        return pedidoRetorno;
    }
    public static PedidoDTO toDTO(Pedido pedido) {
        PedidoDTO pedidoRetorno = new PedidoDTO();
        pedidoRetorno.setId(pedido.getId());
        pedidoRetorno.setDataPedido(pedido.getDataPedido());
        pedidoRetorno.setStatusPedido(pedido.getStatusPedido());
        pedidoRetorno.setProdutos(pedido.getProdutos().stream().map(Produto::getId).toList());
        pedidoRetorno.setComprador(pedido.getComprador().getId());
        pedidoRetorno.setEntrega(MapperEntrega.toDTO(pedido.getEntrega()));
        pedidoRetorno.setPagamento(MapperPagamento.toDTO(pedido.getPagamento()));
        return pedidoRetorno;
    }
}

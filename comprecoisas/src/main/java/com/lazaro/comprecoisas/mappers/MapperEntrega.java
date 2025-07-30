package com.lazaro.comprecoisas.mappers;

import com.lazaro.comprecoisas.model.Entrega;
import com.lazaro.comprecoisas.model.dtos.EntregaDTO;

public class MapperEntrega {
    public static Entrega toEntity(EntregaDTO entrega) {
        Entrega entregaRetorno = new Entrega();
        entregaRetorno.setId(entrega.getId());
        entregaRetorno.setFrete(entrega.getFrete());
        entregaRetorno.setStatus(entrega.getStatus());
        entregaRetorno.setIdRastreamento(entrega.getIdRastreamento());
        entregaRetorno.setTransportadora(entrega.getTransportadora());
        entregaRetorno.setDataEntrega(entrega.getDataEntrega());
        entregaRetorno.setPrevisaoEntrega(entrega.getPrevisaoEntrega());
        entregaRetorno.setEnderecoEntrega(MapperEndereco.toEntity(entrega.getEnderecoEntrega()));
        return entregaRetorno;
    }
    public static EntregaDTO toDTO(Entrega entrega) {
        EntregaDTO entregaRetorno = new EntregaDTO();
        entregaRetorno.setId(entrega.getId());
        entregaRetorno.setFrete(entrega.getFrete());
        entregaRetorno.setStatus(entrega.getStatus());
        entregaRetorno.setIdRastreamento(entrega.getIdRastreamento());
        entregaRetorno.setTransportadora(entrega.getTransportadora());
        entregaRetorno.setDataEntrega(entrega.getDataEntrega());
        entregaRetorno.setPrevisaoEntrega(entrega.getPrevisaoEntrega());
        entregaRetorno.setEnderecoEntrega(MapperEndereco.toDTO(entrega.getEnderecoEntrega()));
        return entregaRetorno;

    }
}

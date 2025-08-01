package com.lazaro.comprecoisas.mappers;

import com.lazaro.comprecoisas.model.Entrega;
import com.lazaro.comprecoisas.model.dtos.EntregaResponseDTO;

public class MapperEntrega {
    public static Entrega toEntity(EntregaResponseDTO entrega) {
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
    public static EntregaResponseDTO toDTO(Entrega entrega) {
        EntregaResponseDTO entregaRetorno = new EntregaResponseDTO();
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

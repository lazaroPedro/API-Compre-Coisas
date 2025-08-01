package com.lazaro.comprecoisas.mappers;

import com.lazaro.comprecoisas.model.Entrega;
import com.lazaro.comprecoisas.model.dtos.EntregaRequestDTO;

public class MapperEntregaRequest {
    public static Entrega toEntity(EntregaRequestDTO entrega) {
        Entrega entregaRetorno = new Entrega();
        entregaRetorno.setTransportadora(entrega.getTransportadora());
        entregaRetorno.setEnderecoEntrega(MapperEnderecoRequest.toEntity(entrega.getEnderecoEntrega()));
        return entregaRetorno;
    }
    public static EntregaRequestDTO toDTO(Entrega entrega) {
        EntregaRequestDTO entregaRetorno = new EntregaRequestDTO();
        entregaRetorno.setTransportadora(entrega.getTransportadora());
        entregaRetorno.setEnderecoEntrega(MapperEnderecoRequest.toDTO(entrega.getEnderecoEntrega()));
        return entregaRetorno;

    }
}

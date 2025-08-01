package com.lazaro.comprecoisas.mappers;

import com.lazaro.comprecoisas.model.Endereco;
import com.lazaro.comprecoisas.model.dtos.EnderecoRequestDTO;

public class MapperEnderecoRequest {
    public static Endereco toEntity(EnderecoRequestDTO endereco) {
        Endereco enderecoRetorno = new Endereco();

        enderecoRetorno.setRua(endereco.getRua());
        enderecoRetorno.setNumero(endereco.getNumero());
        enderecoRetorno.setBairro(endereco.getBairro());
        enderecoRetorno.setMunicipio(endereco.getMunicipio());
        enderecoRetorno.setEstado(endereco.getEstado());
        enderecoRetorno.setCep(endereco.getCep());

        return enderecoRetorno;
    }
    public static EnderecoRequestDTO toDTO(Endereco endereco) {
        EnderecoRequestDTO enderecoRetorno = new EnderecoRequestDTO();
        enderecoRetorno.setRua(endereco.getRua());
        enderecoRetorno.setNumero(endereco.getNumero());
        enderecoRetorno.setBairro(endereco.getBairro());
        enderecoRetorno.setMunicipio(endereco.getMunicipio());
        enderecoRetorno.setEstado(endereco.getEstado());
        enderecoRetorno.setCep(endereco.getCep());

        return enderecoRetorno;
    }

}

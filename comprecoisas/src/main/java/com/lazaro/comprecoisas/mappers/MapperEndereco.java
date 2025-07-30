package com.lazaro.comprecoisas.mappers;

import com.lazaro.comprecoisas.model.Endereco;
import com.lazaro.comprecoisas.model.dtos.EnderecoDTO;

public class MapperEndereco {
    public static Endereco toEntity(EnderecoDTO endereco) {
        Endereco enderecoRetorno = new Endereco();
        enderecoRetorno.setId(endereco.getId());
        enderecoRetorno.setRua(endereco.getRua());
        enderecoRetorno.setNumero(endereco.getNumero());
        enderecoRetorno.setBairro(endereco.getBairro());
        enderecoRetorno.setMunicipio(endereco.getMunicipio());
        enderecoRetorno.setEstado(endereco.getEstado());
        enderecoRetorno.setCep(endereco.getCep());

        return enderecoRetorno;
    }
    public static EnderecoDTO toDTO(Endereco endereco) {
        EnderecoDTO enderecoRetorno = new EnderecoDTO();
        enderecoRetorno.setId(endereco.getId());
        enderecoRetorno.setRua(endereco.getRua());
        enderecoRetorno.setNumero(endereco.getNumero());
        enderecoRetorno.setBairro(endereco.getBairro());
        enderecoRetorno.setMunicipio(endereco.getMunicipio());
        enderecoRetorno.setEstado(endereco.getEstado());
        enderecoRetorno.setCep(endereco.getCep());

        return enderecoRetorno;
    }

}

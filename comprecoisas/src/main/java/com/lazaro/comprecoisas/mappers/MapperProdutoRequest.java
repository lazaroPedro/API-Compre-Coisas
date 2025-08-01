package com.lazaro.comprecoisas.mappers;

import com.lazaro.comprecoisas.model.Produto;
import com.lazaro.comprecoisas.model.dtos.ProdutoRequestDTO;

public class MapperProdutoRequest {
    private MapperProdutoRequest() {}
    public static Produto toEntity(ProdutoRequestDTO produto) {
        Produto produtoRetorno = new Produto();

        produtoRetorno.setTitulo(produto.getTitulo());
        produtoRetorno.setDescricao(produto.getDescricao());
        produtoRetorno.setValor(produto.getValor());
        produtoRetorno.setDesconto(produto.getDesconto());

        produtoRetorno.setEnderecoOrigem(MapperEnderecoRequest.toEntity(produto.getEnderecoOrigem()));

        return produtoRetorno;
    }
    public static ProdutoRequestDTO toDTO(Produto produto) {
        ProdutoRequestDTO produtoRetorno = new ProdutoRequestDTO();
        produtoRetorno.setTitulo(produto.getTitulo());
        produtoRetorno.setDescricao(produto.getDescricao());
        produtoRetorno.setValor(produto.getValor());
        produtoRetorno.setDesconto(produto.getDesconto());
        produtoRetorno.setCategoriaId(produto.getCategoria().getId());
        produtoRetorno.setVendedorId(produto.getVendedor().getId());
        produtoRetorno.setEnderecoOrigem(MapperEnderecoRequest.toDTO(produto.getEnderecoOrigem()));
        return produtoRetorno;
    }
}

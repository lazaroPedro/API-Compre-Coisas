package com.lazaro.comprecoisas.mappers;

import com.lazaro.comprecoisas.model.Produto;
import com.lazaro.comprecoisas.model.dtos.ProdutoResponseDTO;

public class MapperProdutoResponse {
    private MapperProdutoResponse() {}
    public static Produto toEntity(ProdutoResponseDTO produto) {
        Produto produtoRetorno = new Produto();
        produtoRetorno.setId(produto.getId());
        produtoRetorno.setTitulo(produto.getTitulo());
        produtoRetorno.setDescricao(produto.getDescricao());
        produtoRetorno.setValor(produto.getValor());
        produtoRetorno.setDesconto(produto.getDesconto());
        produtoRetorno.setDataCadastro(produto.getDataCadastro());
        produtoRetorno.setStatusProduto(produto.getStatusProduto());
        produtoRetorno.setEnderecoOrigem(MapperEndereco.toEntity(produto.getEnderecoOrigem()));

        return produtoRetorno;
    }
    public static ProdutoResponseDTO toDTO(Produto produto) {
        ProdutoResponseDTO produtoRetorno = new ProdutoResponseDTO();
        produtoRetorno.setId(produto.getId());
        produtoRetorno.setTitulo(produto.getTitulo());
        produtoRetorno.setDescricao(produto.getDescricao());
        produtoRetorno.setValor(produto.getValor());
        produtoRetorno.setDesconto(produto.getDesconto());
        produtoRetorno.setDataCadastro(produto.getDataCadastro());
        produtoRetorno.setStatusProduto(produto.getStatusProduto());
        produtoRetorno.setCategoriaId(produto.getCategoria().getId());
        produtoRetorno.setVendedorId(produto.getVendedor().getId());
        produtoRetorno.setEnderecoOrigem(MapperEndereco.toDTO(produto.getEnderecoOrigem()));
        return produtoRetorno;
    }
}

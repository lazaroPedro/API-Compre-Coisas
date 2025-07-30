package com.lazaro.comprecoisas.mappers;

import com.lazaro.comprecoisas.model.Produto;
import com.lazaro.comprecoisas.model.dtos.ProdutoDTO;

public class MapperProduto {
    private MapperProduto() {}
    public static Produto toEntity(ProdutoDTO produto) {
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
    public static ProdutoDTO toDTO(Produto produto) {
        ProdutoDTO produtoRetorno = new ProdutoDTO();
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

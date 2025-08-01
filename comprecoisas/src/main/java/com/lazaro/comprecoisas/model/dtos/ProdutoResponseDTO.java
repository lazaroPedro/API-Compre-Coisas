package com.lazaro.comprecoisas.model.dtos;

import com.lazaro.comprecoisas.model.enums.StatusProduto;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class ProdutoResponseDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private BigDecimal valor;
    private Float desconto;
    private LocalDateTime dataCadastro;
    private Long categoriaId;
    private StatusProduto statusProduto;
    private EnderecoResponseDTO enderecoOrigem;
    private Long vendedorId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Float getDesconto() {
        return desconto;
    }

    public void setDesconto(Float desconto) {
        this.desconto = desconto;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public StatusProduto getStatusProduto() {
        return statusProduto;
    }

    public void setStatusProduto(StatusProduto statusProduto) {
        this.statusProduto = statusProduto;
    }

    public EnderecoResponseDTO getEnderecoOrigem() {
        return enderecoOrigem;
    }

    public void setEnderecoOrigem(EnderecoResponseDTO enderecoOrigem) {
        this.enderecoOrigem = enderecoOrigem;
    }

    public Long getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(Long vendedorId) {
        this.vendedorId = vendedorId;
    }
}

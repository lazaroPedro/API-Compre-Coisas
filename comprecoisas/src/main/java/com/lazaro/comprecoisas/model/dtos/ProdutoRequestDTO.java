package com.lazaro.comprecoisas.model.dtos;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;


public class ProdutoRequestDTO {


    @NotBlank
    private String titulo;
    @NotBlank
    private String descricao;
    private BigDecimal valor;
    @Min(0)
    @Max(100)
    private Float desconto;
    @NotNull
    private Long categoriaId;
    @NotNull
    private EnderecoRequestDTO enderecoOrigem;
    @NotNull
    private Long vendedorId;


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


    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public EnderecoRequestDTO getEnderecoOrigem() {
        return enderecoOrigem;
    }

    public void setEnderecoOrigem(EnderecoRequestDTO enderecoOrigem) {
        this.enderecoOrigem = enderecoOrigem;
    }

    public Long getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(Long vendedorId) {
        this.vendedorId = vendedorId;
    }
}

package com.lazaro.comprecoisas.model.dtos;

import com.lazaro.comprecoisas.model.enums.StatusProduto;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


public class ProdutoDTO {

    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    @Positive
    @NotNull
    private Double valor;

    @Min(0)
    @Max(100)
    private Float desconto;


    private LocalDateTime dataCadastro;

    @NotNull
    private Long categoriaId;

    private StatusProduto statusProduto;

    @NotNull
    private EnderecoDTO enderecoOrigem;

    @NotNull
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
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

    public EnderecoDTO getEnderecoOrigem() {
        return enderecoOrigem;
    }

    public void setEnderecoOrigem(EnderecoDTO enderecoOrigem) {
        this.enderecoOrigem = enderecoOrigem;
    }

    public Long getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(Long vendedorId) {
        this.vendedorId = vendedorId;
    }
}

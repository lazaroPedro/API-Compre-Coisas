package com.lazaro.comprecoisas.model.dtos;

import com.lazaro.comprecoisas.model.enums.StatusEntrega;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;


public class EntregaDTO {

    private Long id;

    private BigDecimal frete;

    @NotNull
    private StatusEntrega status;

    @NotNull
    private String idRastreamento;

    @NotNull
    private String transportadora;

    private LocalDate dataEntrega;

    private LocalDate previsaoEntrega;

    @NotNull
    private EnderecoDTO enderecoEntrega;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getFrete() {
        return frete;
    }

    public void setFrete(BigDecimal frete) {
        this.frete = frete;
    }

    public StatusEntrega getStatus() {
        return status;
    }

    public void setStatus(StatusEntrega status) {
        this.status = status;
    }

    public String getIdRastreamento() {
        return idRastreamento;
    }

    public void setIdRastreamento(String idRastreamento) {
        this.idRastreamento = idRastreamento;
    }

    public String getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(String transportadora) {
        this.transportadora = transportadora;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public LocalDate getPrevisaoEntrega() {
        return previsaoEntrega;
    }

    public void setPrevisaoEntrega(LocalDate previsaoEntrega) {
        this.previsaoEntrega = previsaoEntrega;
    }

    public EnderecoDTO getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(EnderecoDTO enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public EntregaDTO() {
    }
}

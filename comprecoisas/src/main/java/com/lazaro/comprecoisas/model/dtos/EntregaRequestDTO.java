package com.lazaro.comprecoisas.model.dtos;

import com.lazaro.comprecoisas.model.enums.StatusEntrega;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;


public class EntregaRequestDTO {

    @NotNull
    private String transportadora;

    @NotNull
    private EnderecoRequestDTO enderecoEntrega;




    public String getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(String transportadora) {
        this.transportadora = transportadora;
    }

    public EnderecoRequestDTO getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(EnderecoRequestDTO enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public EntregaRequestDTO() {
    }
}

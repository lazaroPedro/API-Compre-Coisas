package com.lazaro.comprecoisas.model;

import com.lazaro.comprecoisas.model.enums.StatusEntrega;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "entregas")
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrega")
    private Long id;

    private BigDecimal frete;

    @Column(name = "status_entrega")
    private StatusEntrega status;

    @Column(name = "id_rastreamento")
    private String idRastreamento;

    private String transportadora;

    @ManyToOne
    @JoinColumn(name = "fk_endereco_entrega")
    private Endereco enderecoEntrega;

    @Column(name = "data_entrega")
    private LocalDate dataEntrega;

    @Column(name = "previsao_entrega")
    private LocalDate previsaoEntrega;

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

    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
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

    public Entrega() {
    }
}

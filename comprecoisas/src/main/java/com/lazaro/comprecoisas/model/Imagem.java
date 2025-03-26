package com.lazaro.comprecoisas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "imagens")
public class Imagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imagens")
    private Long id;

    private String caminho;

    @ManyToOne
    @JoinColumn(name = "fk_produtos")
    private Produto produto;

    public Imagem() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}

package com.lazaro.comprecoisas.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pedidoId;

    private LocalDateTime dataPedido;

    private BigDecimal valorTotal;

    private BigDecimal frete;

    @ManyToOne
    private Entrega entrega;

    @ManyToOne
    private Pagamento pagamento;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "itens_pedidos",
            joinColumns = @JoinColumn(name = "fk_produtos"),
            inverseJoinColumns = @JoinColumn(name = "fk_pedidos")
    )
    private List<Produto> produto;
}

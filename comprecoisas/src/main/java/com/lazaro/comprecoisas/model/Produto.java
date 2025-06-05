package com.lazaro.comprecoisas.model;
import com.lazaro.comprecoisas.model.enums.StatusPedido;
import com.lazaro.comprecoisas.model.enums.StatusProduto;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
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


    @CreationTimestamp
    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;


    @ManyToOne
    @JoinColumn(name = "fk_categoria")
    @NotNull
    private Categoria categoria;

    @Column(name = "status_produto")
    private StatusProduto statusProduto;

    @OneToOne
    @JoinColumn(name = "fk_endereco_origem")
    private Endereco enderecoOrigem;

    @ManyToOne
    @JoinColumn(name = "fk_vendedor")
    private Usuario vendedor;

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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public StatusProduto getStatusProduto() {
        return statusProduto;
    }

    public void setStatusProduto(StatusProduto statusProduto) {
        this.statusProduto = statusProduto;
    }

    public Endereco getEnderecoOrigem() {
        return enderecoOrigem;
    }

    public void setEnderecoOrigem(Endereco enderecoOrigem) {
        this.enderecoOrigem = enderecoOrigem;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    public Produto() {
    }
}

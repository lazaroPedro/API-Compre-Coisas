package com.lazaro.comprecoisas.service;

import com.lazaro.comprecoisas.infra.utils.EntregaGenerator;
import com.lazaro.comprecoisas.mappers.MapperPedido;
import com.lazaro.comprecoisas.mappers.MapperPedidoRequest;
import com.lazaro.comprecoisas.model.Pedido;
import com.lazaro.comprecoisas.model.dtos.PedidoResponseDTO;
import com.lazaro.comprecoisas.model.dtos.PedidoRequestDTO;
import com.lazaro.comprecoisas.model.enums.StatusPagamento;
import com.lazaro.comprecoisas.model.enums.StatusPedido;
import com.lazaro.comprecoisas.repository.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final UsuarioRepository usuarioRepository;
    private final ProdutoRepository produtoRepository;
    private final EntregaRepository entregaRepository;
    private final PagamentoRepository pagamentoRepository;


    @Autowired
    public PedidoService(PedidoRepository pedidoRepository, UsuarioRepository usuarioRepository, ProdutoRepository produtoRepository, EntregaRepository entregaRepository, PagamentoRepository pagamentoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.usuarioRepository = usuarioRepository;
        this.produtoRepository = produtoRepository;
        this.entregaRepository = entregaRepository;
        this.pagamentoRepository = pagamentoRepository;
    }

    public Optional<Pedido> findById(Long id) {
        return pedidoRepository.findById(id);
    }
    @Transactional
    public Optional<PedidoResponseDTO> createPedido(PedidoRequestDTO pedidoDTO) {
        Pedido pedido = MapperPedidoRequest.toEntity(pedidoDTO);
        pedido.setComprador(usuarioRepository.findById(pedidoDTO.getComprador())
                .orElseThrow(() -> new EntityNotFoundException("Comprador with id " + pedidoDTO.getComprador() + " not found")));
        pedido.setProdutos(produtoRepository.findByIdIn(pedidoDTO.getProdutos()));
        if (pedido.getProdutos().isEmpty()) {
            throw new EntityNotFoundException("Products with ids " + pedidoDTO.getProdutos() + " not found");
        }

        pedido.setEntrega(EntregaGenerator.gerarEntrega(pedido.getEntrega()));

        pedido.getPagamento().setValorTotal(pedido.getProdutos().stream().map(produto -> {
            BigDecimal desconto = BigDecimal.valueOf(produto.getDesconto()).multiply(BigDecimal.valueOf(0.01));
            BigDecimal fator = BigDecimal.ONE.subtract(desconto);
            return produto.getValor().multiply(fator);
        }).reduce(BigDecimal.ZERO, BigDecimal::add));
        pedido.getPagamento().setStatusPagamento(StatusPagamento.PROCESSAMENTO);
        pedido.getPagamento().setIdTransacao(UUID.randomUUID().toString());
        pedido.setStatusPedido(StatusPedido.PROCESSAMENTO);

        pagamentoRepository.save(pedido.getPagamento());
        entregaRepository.save(pedido.getEntrega());
        pedidoRepository.save(pedido);

        return Optional.of(MapperPedido.toDTO(pedido));




    }
}

package com.lazaro.comprecoisas.service;

import com.lazaro.comprecoisas.model.Pedido;
import com.lazaro.comprecoisas.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Optional<Pedido> findById(Long id) {
        return pedidoRepository.findById(id);
    }

    public Optional<Pedido> createPedido(Pedido pedido) {

    }
}

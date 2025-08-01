package com.lazaro.comprecoisas.controller;

import com.lazaro.comprecoisas.model.Pedido;
import com.lazaro.comprecoisas.model.dtos.PedidoResponseDTO;
import com.lazaro.comprecoisas.model.dtos.PedidoRequestDTO;
import com.lazaro.comprecoisas.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class PedidoController {
    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<Pedido> showPedido(@PathVariable Long id) {
        return pedidoService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<PedidoResponseDTO> addPedido(@RequestBody @Valid PedidoRequestDTO pedido) {
        return pedidoService.createPedido(pedido).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

}

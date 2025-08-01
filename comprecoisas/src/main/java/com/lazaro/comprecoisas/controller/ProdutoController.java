package com.lazaro.comprecoisas.controller;

import com.lazaro.comprecoisas.model.dtos.ProdutoResponseDTO;
import com.lazaro.comprecoisas.model.dtos.ProdutoRequestDTO;
import com.lazaro.comprecoisas.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/products")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<ProdutoResponseDTO> showProdutos() {
        return produtoService.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProdutoResponseDTO> showProdutoByID(@PathVariable Long id) {
        Optional<ProdutoResponseDTO> prod = produtoService.findById(id);
        return prod.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/cat/{categoria}")
    public List<ProdutoResponseDTO> showProdutosByCategoria(@PathVariable Long categoria) {
        return produtoService.findByCategoria(categoria);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> createProduto(@Valid @RequestBody ProdutoRequestDTO produto) {
        return produtoService.salvarProduto(produto).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<ProdutoResponseDTO> atualizarProduto(@Valid @RequestBody ProdutoRequestDTO produto) {
        return produtoService.salvarProduto(produto).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

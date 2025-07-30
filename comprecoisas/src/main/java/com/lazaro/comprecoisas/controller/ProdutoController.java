package com.lazaro.comprecoisas.controller;

import com.lazaro.comprecoisas.model.Categoria;
import com.lazaro.comprecoisas.model.Produto;
import com.lazaro.comprecoisas.model.dtos.ProdutoDTO;
import com.lazaro.comprecoisas.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
    public List<ProdutoDTO> showProdutos() {
        return produtoService.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProdutoDTO> showProdutoByID(@PathVariable Long id) {
        Optional<ProdutoDTO> prod = produtoService.findById(id);
        return prod.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/cat/{categoria}")
    public List<ProdutoDTO> showProdutosByCategoria(@PathVariable Long categoria) {
        return produtoService.findByCategoria(categoria);
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> createProduto(@Valid @RequestBody ProdutoDTO produto) {
        return produtoService.salvarProduto(produto).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<ProdutoDTO> atualizarProduto(@Valid @RequestBody ProdutoDTO produto) {
        return produtoService.salvarProduto(produto).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

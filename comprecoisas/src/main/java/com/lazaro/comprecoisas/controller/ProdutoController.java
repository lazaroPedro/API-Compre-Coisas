package com.lazaro.comprecoisas.controller;

import com.lazaro.comprecoisas.model.Categoria;
import com.lazaro.comprecoisas.model.Produto;
import com.lazaro.comprecoisas.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> showProdutos() {
        return produtoService.buscarProdutos();
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Produto> showProdutoByID(@PathVariable Long id) {
        Optional<Produto> prod = produtoService.buscarProdutoPorId(id);
        return prod.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/cat/{categoria}")
    public List<Produto> showProdutosByCategoria(@PathVariable Long categoria) {
        return produtoService.buscarProdutosPorCategoria(categoria);
    }

    @GetMapping(path = "/cat")
    public List<Categoria> showCategoria() {
        return produtoService.buscarCat();
    }

    @PostMapping
    public ResponseEntity<Produto> salvarProduto(@Valid @RequestBody Produto produto) {
        Optional<Produto> prod = produtoService.salvarProduto(produto);
        return prod.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());


    }
    @DeleteMapping(path = "/id/{id}")
    public ResponseEntity<Produto> excluirProduto( @RequestBody Long id) {
        return null;
    }
    @PatchMapping
    public ResponseEntity<Produto> atualizarProduto( @RequestBody Produto produto) {
        return null;
    }
}

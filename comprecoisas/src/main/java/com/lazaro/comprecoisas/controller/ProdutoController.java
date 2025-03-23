package com.lazaro.comprecoisas.controller;

import com.lazaro.comprecoisas.model.Produto;
import com.lazaro.comprecoisas.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    @ResponseBody
    public List<Produto> showProdutos() {
        return produtoService.buscarProdutos();
    }
/*
    @GetMapping(path = "/{id}")
    @ResponseBody
    public ResponseEntity<Produto> showProdutoByID(@PathVariable String id) {

        return produtoService.buscarProdutoPorId(id);
    }

    @PostMapping
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {


    }*/
}

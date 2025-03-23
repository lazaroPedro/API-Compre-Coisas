package com.lazaro.comprecoisas.service;

import com.lazaro.comprecoisas.model.Produto;
import com.lazaro.comprecoisas.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repoProd;

    public List<Produto> buscarProdutos() {
        return repoProd.findAll();
    }

    public Produto buscarProdutoPorId(String id) {


            Long idProduto = Long.parseLong(id);
            return repoProd.findById(idProduto).get();


    }
}

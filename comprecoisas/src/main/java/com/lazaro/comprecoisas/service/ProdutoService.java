package com.lazaro.comprecoisas.service;

import com.lazaro.comprecoisas.model.Categoria;
import com.lazaro.comprecoisas.model.Produto;
import com.lazaro.comprecoisas.repository.CategoriaRepository;
import com.lazaro.comprecoisas.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository repoProd;

    private final CategoriaRepository repoCat;

    @Autowired
    public ProdutoService(ProdutoRepository repoProd, CategoriaRepository repoCat) {
        this.repoProd = repoProd;
        this.repoCat = repoCat;
    }

    public List<Produto> buscarProdutos() {
        return repoProd.findAll();
    }
    public List<Categoria> buscarCat() {
        return repoCat.findAll();
    }
    public Optional<Produto> buscarProdutoPorId(Long id) {

            return repoProd.findById(id);


    }

    public Optional<Produto> salvarProduto(Produto produto) {
        Optional<Categoria> categoriaOp = repoCat.findById(produto.getSubCategoria().getId());
          produto.setSubCategoria(categoriaOp.get());

        if (categoriaOp.isPresent() && produto.getSubCategoria().getCategoriaPai() != null) {
            if(produto.getDesconto() == null){
                produto.setDesconto(0f);
            }
            repoProd.save(produto);
            return Optional.of(produto);
        }else{
            return Optional.empty();
        }


    }

    public List<Produto> buscarProdutosPorCategoria(Long categoria) {
        Optional<Categoria> categoriaOp = repoCat.findById(categoria);
        if (categoriaOp.isPresent()) {
         return repoProd.findProdutoBySubCategoria(categoriaOp.get());
        } else {
            return null;
        }
    }
}

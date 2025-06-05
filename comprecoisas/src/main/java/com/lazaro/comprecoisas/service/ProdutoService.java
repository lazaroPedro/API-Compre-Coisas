package com.lazaro.comprecoisas.service;

import com.lazaro.comprecoisas.exceptions.NullCategoriaPaiException;
import com.lazaro.comprecoisas.model.Categoria;
import com.lazaro.comprecoisas.model.Produto;
import com.lazaro.comprecoisas.model.Status;
import com.lazaro.comprecoisas.repository.CategoriaRepository;
import com.lazaro.comprecoisas.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
       /* return repoProd.findAll().stream().filter(produto -> {
            return (produto.getStatusProduto() == Status.ATIVO);
        }).collect(Collectors.toList());*/
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

        if (categoriaOp.isPresent()) {
            if (produto.getSubCategoria().getCategoriaPai() == null){
                throw new NullCategoriaPaiException();
            }
            if(produto.getDesconto() == null){
                produto.setDesconto(0f);
            }
            produto.setId(null);
            repoProd.save(produto);
            return Optional.of(produto);
        }else{
            return Optional.empty();
        }


    }
    public List<Produto> buscarProdutoPorCategoriaPai(Categoria pai) {
        List<Produto> lista = new ArrayList<>();
        repoCat.findCategoriaByCategoriaPai(pai).forEach(categoria -> {
            lista.addAll(repoProd.findProdutoBySubCategoria(categoria));
        });

        return lista;
    }




    public List<Produto> buscarProdutosPorCategoria(Long categoria) {
        Optional<Categoria> categoriaOp = repoCat.findById(categoria);
        if (categoriaOp.isPresent()) {
            if (categoriaOp.get().getCategoriaPai() == null) {
                return  buscarProdutoPorCategoriaPai(categoriaOp.get());
            }else
         return repoProd.findProdutoBySubCategoria(categoriaOp.get());
        } else {
            return null;
        }
    }
    public void alterarProduto(Produto produto) {
        ;
        repoProd.save(produto);
    }
    public void excluirProduto(Long id){
        Produto produto = repoProd.findById(id).get();
        repoProd.save(produto);
    }
}

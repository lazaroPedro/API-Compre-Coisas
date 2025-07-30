package com.lazaro.comprecoisas.service;

import com.lazaro.comprecoisas.infra.exceptions.NullCategoriaPaiException;
import com.lazaro.comprecoisas.mappers.MapperEndereco;
import com.lazaro.comprecoisas.mappers.MapperProduto;
import com.lazaro.comprecoisas.model.Categoria;
import com.lazaro.comprecoisas.model.Produto;
import com.lazaro.comprecoisas.model.Usuario;
import com.lazaro.comprecoisas.model.dtos.ProdutoDTO;
import com.lazaro.comprecoisas.model.enums.StatusProduto;
import com.lazaro.comprecoisas.repository.CategoriaRepository;
import com.lazaro.comprecoisas.repository.ProdutoRepository;
import com.lazaro.comprecoisas.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository repoProd;
    private final CategoriaRepository repoCat;
    private final UsuarioRepository repoUsu;

    @Autowired
    public ProdutoService(ProdutoRepository repoProd, CategoriaRepository repoCat, UsuarioRepository repoUsu) {
        this.repoProd = repoProd;
        this.repoCat = repoCat;
        this.repoUsu = repoUsu;
    }

    public List<ProdutoDTO> findAll() {
       return repoProd.findByStatusProduto(StatusProduto.ATIVO)
               .stream()
               .map(MapperProduto::toDTO)
               .toList();

    }
    public Optional<ProdutoDTO> findById(Long id) {
        return repoProd.findById(id).map(MapperProduto::toDTO);
    }
    public List<ProdutoDTO> findByCategoria(Long categoria) {
        Optional<Categoria> categoriaOp = repoCat.findById(categoria);
        return categoriaOp.map(value -> repoProd.findByCategoria(value)
                .stream()
                .map(MapperProduto::toDTO)
                .toList()).orElseGet(List::of);

    }

    public Optional<ProdutoDTO> salvarProduto(ProdutoDTO produtoDTO) {
        Produto produto = MapperProduto.toEntity(produtoDTO);
        Categoria cat = repoCat.findById(produtoDTO.getCategoriaId())
                .orElseThrow(() -> new EntityNotFoundException("Categoria with ID: " + produtoDTO.getCategoriaId() + " not found"));
        Usuario usu = repoUsu.findById(produtoDTO.getVendedorId())
                .orElseThrow(() -> new EntityNotFoundException("Vendedor with ID: " + produtoDTO.getVendedorId() + " not found"));
        produto.setCategoria(cat);
        produto.setVendedor(usu);
        if (produto.getCategoria().getCategoriaPai() == null){
            throw new NullCategoriaPaiException();
        }
        repoProd.save(produto);
        return Optional.of(produtoDTO);

    }






}

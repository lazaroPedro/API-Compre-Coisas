package com.lazaro.comprecoisas.service;

import com.lazaro.comprecoisas.infra.exceptions.NullCategoriaPaiException;
import com.lazaro.comprecoisas.mappers.MapperProdutoResponse;
import com.lazaro.comprecoisas.mappers.MapperProdutoRequest;
import com.lazaro.comprecoisas.model.Categoria;
import com.lazaro.comprecoisas.model.Produto;
import com.lazaro.comprecoisas.model.Usuario;
import com.lazaro.comprecoisas.model.dtos.ProdutoResponseDTO;
import com.lazaro.comprecoisas.model.dtos.ProdutoRequestDTO;
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

    public List<ProdutoResponseDTO> findAll() {
       return repoProd.findByStatusProduto(StatusProduto.ATIVO)
               .stream()
               .map(MapperProdutoResponse::toDTO)
               .toList();

    }
    public Optional<ProdutoResponseDTO> findById(Long id) {
        return repoProd.findById(id).map(MapperProdutoResponse::toDTO);
    }
    public List<ProdutoResponseDTO> findByCategoria(Long categoria) {
        Optional<Categoria> categoriaOp = repoCat.findById(categoria);
        return categoriaOp.map(value -> repoProd.findByCategoria(value)
                .stream()
                .map(MapperProdutoResponse::toDTO)
                .toList()).orElseGet(List::of);

    }

    public Optional<ProdutoResponseDTO> salvarProduto(ProdutoRequestDTO produtoDTO) {
        Produto produto = MapperProdutoRequest.toEntity(produtoDTO);
        Categoria cat = repoCat.findById(produtoDTO.getCategoriaId())
                .orElseThrow(() -> new EntityNotFoundException("Categoria with ID: " + produtoDTO.getCategoriaId() + " not found"));
        Usuario usu = repoUsu.findById(produtoDTO.getVendedorId())
                .orElseThrow(() -> new EntityNotFoundException("Vendedor with ID: " + produtoDTO.getVendedorId() + " not found"));
        produto.setCategoria(cat);
        produto.setVendedor(usu);
        produto.setStatusProduto(StatusProduto.ATIVO);
        if (produto.getCategoria().getCategoriaPai() == null){
            throw new NullCategoriaPaiException();
        }
        repoProd.save(produto);
        return Optional.of(MapperProdutoResponse.toDTO(produto));

    }






}

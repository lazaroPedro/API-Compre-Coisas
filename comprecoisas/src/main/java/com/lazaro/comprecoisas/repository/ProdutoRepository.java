package com.lazaro.comprecoisas.repository;

import com.lazaro.comprecoisas.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Produto findProdutoById(Long id);
}

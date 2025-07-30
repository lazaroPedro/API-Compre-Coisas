package com.lazaro.comprecoisas.repository;

import com.lazaro.comprecoisas.model.Categoria;
import com.lazaro.comprecoisas.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}

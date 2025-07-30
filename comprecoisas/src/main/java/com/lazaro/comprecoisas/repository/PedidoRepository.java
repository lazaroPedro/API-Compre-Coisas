package com.lazaro.comprecoisas.repository;

import com.lazaro.comprecoisas.model.Categoria;
import com.lazaro.comprecoisas.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}

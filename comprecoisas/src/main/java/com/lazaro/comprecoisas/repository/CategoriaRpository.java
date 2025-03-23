package com.lazaro.comprecoisas.repository;

import com.lazaro.comprecoisas.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRpository extends JpaRepository<Categoria, Long> {
}

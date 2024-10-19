package com.agenciacafespring.agenciacafej.entity.repository;

import com.agenciacafespring.agenciacafej.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Query(value = "SELECT * FROM categorias", nativeQuery = true)
    List<Categoria> listCategoria();

    @Query(value = "SELECT * FROM categorias WHERE id=:id", nativeQuery = true)
    Categoria searchCategoria(@Param(value = "id") Long id);
}

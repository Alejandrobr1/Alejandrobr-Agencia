package com.agenciacafespring.agenciacafej.entity.repository;

import com.agenciacafespring.agenciacafej.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    @Query(value = "SELECT * FROM productos", nativeQuery = true)
    List<Producto> listProducto();

    @Query(value = "SELECT * FROM productos WHERE id=:id", nativeQuery = true)
    Producto searchProducto(@Param(value = "id") Long id);
}

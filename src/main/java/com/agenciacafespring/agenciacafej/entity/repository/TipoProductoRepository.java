package com.agenciacafespring.agenciacafej.entity.repository;

import com.agenciacafespring.agenciacafej.entity.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TipoProductoRepository extends JpaRepository<TipoProducto, Long> {
    @Query(value = "SELECT * FROM tipo_productos", nativeQuery = true)
    List<TipoProducto> listTipoProducto();

    @Query(value = "SELECT * FROM tipo_productos WHERE id=:id", nativeQuery = true)
    TipoProducto searchTipoProducto(@Param(value = "id") Long id);
}

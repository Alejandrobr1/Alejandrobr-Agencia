package com.agenciacafespring.agenciacafej.entity.repository;

import com.agenciacafespring.agenciacafej.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Long> {
    @Query(value = "SELECT * FROM compras", nativeQuery = true)
    List<Compra> listCompra();

    @Query(value = "SELECT * FROM compras WHERE id=:id", nativeQuery = true)
    Compra searchCompra(@Param(value = "id") Long id);
}

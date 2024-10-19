package com.agenciacafespring.agenciacafej.entity.repository;

import com.agenciacafespring.agenciacafej.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VentaRepository extends JpaRepository<Venta, Long> {
    @Query(value = "SELECT * FROM ventas", nativeQuery = true)
    List<Venta> listVenta();

    @Query(value = "SELECT * FROM ventas WHERE id=:id", nativeQuery = true)
    Venta searchVenta(@Param(value = "id") Long id);
}

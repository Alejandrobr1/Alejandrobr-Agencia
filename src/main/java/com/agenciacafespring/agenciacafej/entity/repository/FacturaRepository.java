package com.agenciacafespring.agenciacafej.entity.repository;

import com.agenciacafespring.agenciacafej.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
    @Query(value = "SELECT * FROM facturas", nativeQuery = true)
    List<Factura> listFactura();

    @Query(value = "SELECT * FROM facturas WHERE id=:id", nativeQuery = true)
    Factura searchFactura(@Param(value = "id") Long id);
}

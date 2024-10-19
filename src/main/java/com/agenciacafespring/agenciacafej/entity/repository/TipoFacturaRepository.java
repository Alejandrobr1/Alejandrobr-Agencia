package com.agenciacafespring.agenciacafej.entity.repository;

import com.agenciacafespring.agenciacafej.entity.TipoFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TipoFacturaRepository extends JpaRepository<TipoFactura, Long> {
    @Query(value = "SELECT * FROM tipo_facturas", nativeQuery = true)
    List<TipoFactura> listTipoFactura();

    @Query(value = "SELECT * FROM tipo_facturas WHERE id=:id", nativeQuery = true)
    TipoFactura searchTipoFactura(@Param(value = "id") Long id);
}

package com.agenciacafespring.agenciacafej.entity.repository;

import com.agenciacafespring.agenciacafej.entity.Producto;
import com.agenciacafespring.agenciacafej.entity.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Long> {
    @Query(value = "SELECT * FROM tipo_documentos", nativeQuery = true)
    List<TipoDocumento> listTipoDocumento();

    @Query(value = "SELECT * FROM tipo_documentos WHERE id=:id", nativeQuery = true)
    TipoDocumento searchTipoDocumento(@Param(value = "id") Long id);
}

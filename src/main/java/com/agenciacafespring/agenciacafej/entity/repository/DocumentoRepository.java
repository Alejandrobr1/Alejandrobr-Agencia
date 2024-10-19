package com.agenciacafespring.agenciacafej.entity.repository;

import com.agenciacafespring.agenciacafej.entity.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {
    @Query(value = "SELECT * FROM documentos", nativeQuery = true)
    List<Documento> listDocumento();

    @Query(value = "SELECT * FROM documentos WHERE id=:id", nativeQuery = true)
    Documento searchDocumento(@Param(value = "id") Long id);
}

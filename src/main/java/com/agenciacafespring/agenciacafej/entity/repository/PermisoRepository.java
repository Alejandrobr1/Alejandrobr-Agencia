package com.agenciacafespring.agenciacafej.entity.repository;

import com.agenciacafespring.agenciacafej.entity.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PermisoRepository extends JpaRepository<Permiso, Long> {
    @Query(value = "SELECT * FROM permisos", nativeQuery = true)
    List<Permiso> listPermiso();

    @Query(value = "SELECT * FROM permisos WHERE id=:id", nativeQuery = true)
    Permiso searchPermiso(@Param(value = "id") Long id);
}

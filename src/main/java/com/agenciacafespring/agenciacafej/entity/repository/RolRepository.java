package com.agenciacafespring.agenciacafej.entity.repository;

import com.agenciacafespring.agenciacafej.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RolRepository extends JpaRepository<Rol, Long> {
    @Query(value = "SELECT * FROM roles", nativeQuery = true)
    List<Rol> listRol();

    @Query(value = "SELECT * FROM roles WHERE id=:id", nativeQuery = true)
    Rol searchRol(@Param(value = "id") Long id);
}

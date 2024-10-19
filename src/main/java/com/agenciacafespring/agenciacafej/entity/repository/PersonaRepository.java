package com.agenciacafespring.agenciacafej.entity.repository;

import com.agenciacafespring.agenciacafej.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

    @Query(value = "SELECT * FROM personas",nativeQuery = true)
    List<Persona> listPerson();

    @Query(value = "SELECT * FROM personas WHERE id=:id",nativeQuery = true)
    Persona searchPerson(@Param(value = "id") Long id);


}

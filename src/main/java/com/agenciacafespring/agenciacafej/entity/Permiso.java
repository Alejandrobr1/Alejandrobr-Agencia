package com.agenciacafespring.agenciacafej.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "permisos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Permiso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo_permiso")
    private String tipoPermiso;

    @ManyToOne //
    @JoinColumn(name = "fk_roles",referencedColumnName = "id",nullable = false)
    private Rol fk_rol;
}

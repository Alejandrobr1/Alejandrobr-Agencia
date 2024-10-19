package com.agenciacafespring.agenciacafej.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipo_productos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre_variedad")
    private String nombreVariedad;

    @ManyToOne //
    @JoinColumn(name = "fk_productos",referencedColumnName = "id",nullable = false)
    private Producto fk_producto;
}

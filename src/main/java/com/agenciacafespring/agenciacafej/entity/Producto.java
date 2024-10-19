package com.agenciacafespring.agenciacafej.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column(name = "cantidad")
    private Double cantidad;

    @Column(name = "peso")
    private Double peso;

    @ManyToOne //
    @JoinColumn(name = "fk_categorias",referencedColumnName = "id",nullable = false)
    private Categoria fk_categoria;
}

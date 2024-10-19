package com.agenciacafespring.agenciacafej.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipo_facturas")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "categoria_factura")
    private String categoriaFactura;

    @ManyToOne //
    @JoinColumn(name = "fk_compras",referencedColumnName = "id",nullable = false)
    private Compra fk_compra;

    @ManyToOne //
    @JoinColumn(name = "fk_ventas",referencedColumnName = "id",nullable = false)
    private Venta fk_venta;
}

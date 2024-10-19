package com.agenciacafespring.agenciacafej.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Table(name = "compras")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha_compra")
    private Date fechaCompra;

    @Column(name = "lugar_compra")
    private String lugarCompra;

    @Column(name = "costo_compra")
    private Double costoCompra;

    @Column(name = "cantidad_compra")
    private Double cantidadCompra;

    @Column(name = "costo_total_compra")
    private Double costoTotal;

    @ManyToOne
    @JoinColumn(name = "fk_tipo_productosc",referencedColumnName = "id",nullable = false)
    private TipoProducto fk_tipo_productoc;
}

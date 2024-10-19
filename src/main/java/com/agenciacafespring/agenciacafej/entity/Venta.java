package com.agenciacafespring.agenciacafej.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Table(name = "ventas")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha_venta")
    private Date fechaVenta;

    @Column(name = "lugar_venta")
    private String lugarVenta;

    @Column(name = "costo_venta")
    private Double costoVenta;

    @Column(name = "cantidad_venta")
    private Double cantidadVenta;

    @Column(name = "costo_total")
    private Double costoTotal;

    @Column(name = "descuento")
    private Double descuento;

    @ManyToOne //
    @JoinColumn(name = "fk_tipo_productos",referencedColumnName = "id",nullable = false)
    private TipoProducto fk_tipo_producto;
}

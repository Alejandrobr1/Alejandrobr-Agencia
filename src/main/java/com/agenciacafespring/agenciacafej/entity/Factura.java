package com.agenciacafespring.agenciacafej.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Table(name = "facturas")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo_pago")
    private String tipoPago;

    @Column(name = "fecha_factura")
    private Date fechaFactura;

    @ManyToOne //
    @JoinColumn(name = "fk_tipo_factura",referencedColumnName = "id",nullable = false)
    private TipoFactura fk_tipo_factura;

    @ManyToOne //
    @JoinColumn(name = "fk_personas",referencedColumnName = "id",nullable = false)
    private Persona fk_persona;
}

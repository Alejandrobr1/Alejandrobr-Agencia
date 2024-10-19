package com.agenciacafespring.agenciacafej.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VentaRequest {
    private Long id;
    private Date fechaVenta;
    private String lugarVenta;
    private Double costoVenta;
    private Double cantidadVenta;
    private Double costoTotal;
    private Double descuento;
    private Long fk_tipo_producto;
}

package com.agenciacafespring.agenciacafej.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class VentaResponse {

    private Long id;
    private Date fechaVenta;
    private String lugarVenta;
    private Double costoVenta;
    private Double cantidadVenta;
    private Double costoTotal;
    private Double descuento;
    private Long fk_tipo_producto;
}

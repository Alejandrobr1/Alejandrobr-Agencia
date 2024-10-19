package com.agenciacafespring.agenciacafej.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FacturaResponse {
    private Long id;
    private String tipoPago;
    private Date fechaFactura;
    private Long fk_tipo_factura;
    private Long fk_persona;
}

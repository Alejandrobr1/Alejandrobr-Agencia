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
public class FacturaRequest {
    private Long id;
    private String tipoPago;
    private Date fechaFactura;
    private Long fk_tipo_factura;
    private Long fk_persona;
    }
package com.agenciacafespring.agenciacafej.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TipoFacturaResponse {
    private Long id;
    private String categoriaFactura;
    private Long fk_compra;
    private Long fk_venta;
}

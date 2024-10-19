package com.agenciacafespring.agenciacafej.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoFacturaRequest {
   private Long id;
   private String categoriaFactura;
   private Long fk_compra;
   private Long fk_venta;
}

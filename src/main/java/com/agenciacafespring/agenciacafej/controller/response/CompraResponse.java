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
public class CompraResponse {
    private Long id;
    private Date fechaCompra;
    private String lugarCompra;
    private Double costoCompra;
    private Double cantidadCompra;
    private Double costoTotal;
    private Long fk_tipo_productoc;
}

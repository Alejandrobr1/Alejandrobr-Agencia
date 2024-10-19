package com.agenciacafespring.agenciacafej.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductoRequest {

    private Long id;
    private String nombreProducto;
    private Double peso;
    private Double cantidad;
    private Long fk_categoria;
}

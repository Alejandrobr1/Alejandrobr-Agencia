package com.agenciacafespring.agenciacafej.controller.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TipoProductoRequest {

    private Long id;
    private String nombreVariedad;
    private Long fk_producto;
}

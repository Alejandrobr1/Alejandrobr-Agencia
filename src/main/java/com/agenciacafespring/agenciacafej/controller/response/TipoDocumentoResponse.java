package com.agenciacafespring.agenciacafej.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TipoDocumentoResponse {
    private Long id;
    private String sigla;
    private String descripcion;
}

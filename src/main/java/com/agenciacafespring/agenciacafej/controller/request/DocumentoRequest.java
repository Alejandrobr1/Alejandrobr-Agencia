package com.agenciacafespring.agenciacafej.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentoRequest {

    private Long id;
    private String documento;
    private Long fk_tipo_documento;
    private Long fk_personasd;

}

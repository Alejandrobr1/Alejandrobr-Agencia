package com.agenciacafespring.agenciacafej.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DocumentoResponse {
    private Long id;
    private String documento;
    private Long fk_tipo_documento;
    private Long fk_personasd;
}

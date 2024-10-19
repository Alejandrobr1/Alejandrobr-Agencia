package com.agenciacafespring.agenciacafej.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PermisoResponse {
    private Long id;
    private String tipoPermiso;
    private Long fk_rol;
}

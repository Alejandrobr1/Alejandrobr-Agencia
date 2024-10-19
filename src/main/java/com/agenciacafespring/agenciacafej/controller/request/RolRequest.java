package com.agenciacafespring.agenciacafej.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RolRequest {

    private Long id;
    private String nombreRol;
    private Long fk_persona_rol;
}

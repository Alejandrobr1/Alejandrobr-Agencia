package com.agenciacafespring.agenciacafej.controller.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaResponse {

    private Long id;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String lugarNacimiento;
    private Boolean estadoSistema;
}

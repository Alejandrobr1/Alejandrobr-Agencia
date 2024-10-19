package com.agenciacafespring.agenciacafej.controller.request;


import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class PersonaRequest {
    private Long id;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String lugarNacimiento;
    private Boolean estadoSistema;
}

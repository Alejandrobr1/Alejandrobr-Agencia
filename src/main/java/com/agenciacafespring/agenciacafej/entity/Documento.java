package com.agenciacafespring.agenciacafej.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "documentos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "documento")
    private String documento;

    @ManyToOne
    @JoinColumn(name = "fk_tipo_documentos",referencedColumnName = "id",nullable = false)
    private TipoDocumento fk_tipo_documento;

    @ManyToOne //
    @JoinColumn(name = "fk_personasd",referencedColumnName = "id",nullable = false)
    private Persona fk_personad;
}

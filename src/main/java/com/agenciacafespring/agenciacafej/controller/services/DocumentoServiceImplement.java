package com.agenciacafespring.agenciacafej.controller.services;

import com.agenciacafespring.agenciacafej.controller.request.*;
import com.agenciacafespring.agenciacafej.controller.response.DocumentoResponse;
import com.agenciacafespring.agenciacafej.controller.services.service.DocumentoService;
import com.agenciacafespring.agenciacafej.entity.*;
import com.agenciacafespring.agenciacafej.entity.repository.DocumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DocumentoServiceImplement implements DocumentoService {
    private final DocumentoRepository documentoRepository;
    @Override
    public List<Documento> getListDocumento() {
        return documentoRepository.listDocumento();
    }

    @Override
    public void deleteDocumento(Long id) {
        documentoRepository.deleteById(id);
    }

    @Override
    public DocumentoResponse searchDocumento(Long id) {
        Documento documento = documentoRepository.searchDocumento(id);
        return  Objects.nonNull(documento) ?
                buildDocumentoResponse(documento) :
                DocumentoResponse.builder().build();
    }

    @Override
    public void saveDocumento(DocumentoRequest documentoRequest) {
        Documento documento = new Documento();
        TipoDocumento tipoDocumento = new TipoDocumento();
        Persona persona = new Persona();
        if(Objects.nonNull(documentoRequest)){
            tipoDocumento.setId(documentoRequest.getFk_tipo_documento());
            persona.setId(documentoRequest.getFk_personasd());
            documento.setDocumento(documentoRequest.getDocumento());
            documento.setFk_personad(persona);
            documento.setFk_tipo_documento(tipoDocumento);
            documentoRepository.save(documento);
        }
    }

    @Override
    public void updateDocumento(DocumentoRequest documentoRequest) {
        if(Objects.nonNull(documentoRequest)){
            Optional<Documento> documento = documentoRepository.findById(documentoRequest.getId());
            if(documento.isPresent()){
                Documento documentoActualizar = buildDocumentoEntity(documentoRequest);
                documentoRepository.save(documentoActualizar);
            }
        }
    }


    private static Documento buildDocumentoEntity(DocumentoRequest documentoRequest) {
        return Documento.builder()
                .id(documentoRequest.getId())
                .documento(documentoRequest.getDocumento())
                .fk_personad(buildPersonasEntity(documentoRequest))
                .fk_tipo_documento(buildTipoDocumentoEntity(documentoRequest))
                .build();
    }
    private static TipoDocumento buildTipoDocumentoEntity(DocumentoRequest documentoRequest) {
        return TipoDocumento.builder()
                .id(documentoRequest.getFk_tipo_documento())
                .build();
    }
    private static Persona buildPersonasEntity(DocumentoRequest documentoRequest) {
        return Persona.builder()
                .id(documentoRequest.getFk_personasd())
                .build();
    }

    private static DocumentoResponse buildDocumentoResponse(Documento documento) {
        return DocumentoResponse.builder()
                .id(documento.getId())
                .documento(documento.getDocumento())
                .fk_personasd(buildPersonaResponse(documento.getFk_personad()).getId())
                .fk_tipo_documento(buildTipoDocumentoResponse(documento.getFk_tipo_documento()).getId())
                .build();
    }

    private static TipoDocumento buildTipoDocumentoResponse(TipoDocumento tipoDocumento){
        return TipoDocumento.builder()
                .id(tipoDocumento.getId())
                .sigla(tipoDocumento.getSigla())
                .descripcion(tipoDocumento.getDescripcion())
                .build();
    }
    private static Persona buildPersonaResponse(Persona persona){
        return Persona.builder()
                .id(persona.getId())
                .nombre(persona.getNombre())
                .estadoSistema(persona.getEstadoSistema())
                .fechaNacimiento(persona.getFechaNacimiento())
                .apellido(persona.getApellido())
                .lugarNacimiento(persona.getLugarNacimiento())
                .build();
    }



}

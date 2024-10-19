package com.agenciacafespring.agenciacafej.controller.services.service;

import com.agenciacafespring.agenciacafej.controller.request.DocumentoRequest;
import com.agenciacafespring.agenciacafej.controller.response.DocumentoResponse;
import com.agenciacafespring.agenciacafej.entity.Documento;

import java.util.List;

public interface DocumentoService {

    List<Documento> getListDocumento();
    void deleteDocumento(Long id);
    DocumentoResponse searchDocumento(Long id);
    void saveDocumento(DocumentoRequest documentoRequest);
    void updateDocumento(DocumentoRequest documentoRequest);
}

package com.agenciacafespring.agenciacafej.controller.services.service;

import com.agenciacafespring.agenciacafej.controller.request.TipoDocumentoRequest;
import com.agenciacafespring.agenciacafej.controller.response.TipoDocumentoResponse;
import com.agenciacafespring.agenciacafej.entity.TipoDocumento;

import java.util.List;

public interface TipoDocumentoService {

List<TipoDocumento> getListTipoDocumento();
    void deleteTipoDocumento(Long id);
    TipoDocumentoResponse searchTipoDocumento(Long id);
    void saveTipoDocumento(TipoDocumentoRequest tipoDocumentoRequest);
    void updateTipoDocumento(TipoDocumentoRequest tipoDocumentoRequest);
}



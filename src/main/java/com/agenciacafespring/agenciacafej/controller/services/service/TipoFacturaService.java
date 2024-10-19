package com.agenciacafespring.agenciacafej.controller.services.service;

import com.agenciacafespring.agenciacafej.controller.request.TipoFacturaRequest;
import com.agenciacafespring.agenciacafej.controller.response.TipoFacturaResponse;
import com.agenciacafespring.agenciacafej.entity.TipoFactura;

import java.util.List;

public interface TipoFacturaService {

    List<TipoFactura> getListTipoFactura();
    void deleteTipoFactura(Long id);
    TipoFacturaResponse searchTipoFactura(Long id);
    void saveTipoFactura(TipoFacturaRequest tipoFacturaRequest);
    void updateTipoFactura(TipoFacturaRequest tipoFacturaRequest);
}

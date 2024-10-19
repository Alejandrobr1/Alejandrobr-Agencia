package com.agenciacafespring.agenciacafej.controller.services.service;

import com.agenciacafespring.agenciacafej.controller.request.TipoProductoRequest;
import com.agenciacafespring.agenciacafej.controller.response.TipoProductoResponse;
import com.agenciacafespring.agenciacafej.entity.TipoProducto;

import java.util.List;

public interface TipoProductoService {

    List<TipoProducto> getListTipoProducto();
    void deleteTipoProducto(Long id);
    TipoProductoResponse searchTipoProducto(Long id);
    void saveTipoProducto(TipoProductoRequest tipoProductoRequest);
    void updateTipoProducto(TipoProductoRequest tipoProductoRequest);
}

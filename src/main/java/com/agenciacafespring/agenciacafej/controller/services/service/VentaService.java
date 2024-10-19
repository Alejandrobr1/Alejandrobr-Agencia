package com.agenciacafespring.agenciacafej.controller.services.service;

import com.agenciacafespring.agenciacafej.controller.request.VentaRequest;
import com.agenciacafespring.agenciacafej.controller.response.VentaResponse;
import com.agenciacafespring.agenciacafej.entity.Venta;

import java.util.List;

public interface VentaService {

    List<Venta> getListaVenta();
    void deleteVenta(Long id);
    VentaResponse searchVenta(Long id);
    void saveVenta(VentaRequest ventaRequest);
    void updateVenta(VentaRequest ventaRequest);
}

package com.agenciacafespring.agenciacafej.controller.services.service;

import com.agenciacafespring.agenciacafej.controller.request.FacturaRequest;
import com.agenciacafespring.agenciacafej.controller.response.FacturaResponse;
import com.agenciacafespring.agenciacafej.entity.Factura;

import java.util.List;

public interface FacturaService {

    List<Factura> getListaFactura();
    void deleteFactura(Long id);
    FacturaResponse searchFactura(Long id);
    void saveFactura(FacturaRequest facturaRequest);
    void updateFactura(FacturaRequest facturaRequest);
}

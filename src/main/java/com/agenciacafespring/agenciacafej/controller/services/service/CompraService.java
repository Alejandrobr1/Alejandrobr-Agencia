package com.agenciacafespring.agenciacafej.controller.services.service;

import com.agenciacafespring.agenciacafej.controller.request.CompraRequest;
import com.agenciacafespring.agenciacafej.controller.response.CompraResponse;
import com.agenciacafespring.agenciacafej.entity.Compra;

import java.util.List;

public interface CompraService {

    List<Compra> getListCompra();
    void deleteCompra(Long id);
    CompraResponse searchCompra(Long id);
    void saveCompra(CompraRequest compraRequest);
    void updateCompra(CompraRequest compraRequest);
}

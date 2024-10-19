package com.agenciacafespring.agenciacafej.controller.services.service;

import com.agenciacafespring.agenciacafej.controller.request.ProductoRequest;
import com.agenciacafespring.agenciacafej.controller.response.ProductoResponse;
import com.agenciacafespring.agenciacafej.entity.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> getListProducto();
    void deleteProducto(Long id);
    ProductoResponse searchProducto(Long id);
    void saveProducto(ProductoRequest productoRequest);
    void updateProducto(ProductoRequest productoRequest);
}

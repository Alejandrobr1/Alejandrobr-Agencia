package com.agenciacafespring.agenciacafej.controller.services.service;

import com.agenciacafespring.agenciacafej.controller.request.CategoriaRequest;
import com.agenciacafespring.agenciacafej.controller.response.CategoriaResponse;
import com.agenciacafespring.agenciacafej.entity.Categoria;

import java.util.List;

public interface CategoriaService {

    List<Categoria> getListCategoria();
    void deleteCategoria(Long id);
    CategoriaResponse searchCategoria(Long id);
    void saveCategoria(CategoriaRequest categoriaRequest);
    void updateCategoria(CategoriaRequest categoriaRequest);
}

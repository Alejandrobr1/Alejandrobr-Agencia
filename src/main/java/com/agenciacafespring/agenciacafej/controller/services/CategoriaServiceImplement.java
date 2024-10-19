package com.agenciacafespring.agenciacafej.controller.services;

import com.agenciacafespring.agenciacafej.controller.request.CategoriaRequest;
import com.agenciacafespring.agenciacafej.controller.response.CategoriaResponse;
import com.agenciacafespring.agenciacafej.controller.services.service.CatergoriaService;
import com.agenciacafespring.agenciacafej.entity.Categoria;
import com.agenciacafespring.agenciacafej.entity.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImplement implements CatergoriaService {
    private final CategoriaRepository categoriaRepository;
    @Override
    public List<Categoria> getListCategoria() {
        return categoriaRepository.listCategoria();
    }

    @Override
    public void deleteCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public CategoriaResponse searchCategoria(Long id) {
        Categoria categoria = categoriaRepository.searchCategoria(id);
        if(Objects.nonNull(categoria)){
            return  CategoriaResponse.builder()
                    .id(categoria.getId())
                    .nombreCategoria(categoria.getNombreCategoria())
                    .build();
        }
        return CategoriaResponse.builder().build();
    }

    @Override
    public void saveCategoria(CategoriaRequest categoriaRequest) {
        if(Objects.nonNull(categoriaRequest)){
            Categoria categoria = Categoria.builder()
                    .nombreCategoria(categoriaRequest.getNombreCategoria())
                    .build();

            categoriaRepository.save(categoria);
        }
    }

    @Override
    public void updateCategoria(CategoriaRequest categoriaRequest) {
        if(Objects.nonNull(categoriaRequest)){
            Categoria categoria = Categoria.builder()
                    .nombreCategoria(categoriaRequest.getNombreCategoria())
                    .build();

            categoriaRepository.save(categoria);
        }
    }
}

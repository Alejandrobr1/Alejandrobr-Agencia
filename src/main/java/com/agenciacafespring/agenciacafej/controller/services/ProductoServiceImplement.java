package com.agenciacafespring.agenciacafej.controller.services;

import com.agenciacafespring.agenciacafej.controller.request.ProductoRequest;
import com.agenciacafespring.agenciacafej.controller.response.ProductoResponse;
import com.agenciacafespring.agenciacafej.controller.services.service.ProductoService;
import com.agenciacafespring.agenciacafej.entity.*;
import com.agenciacafespring.agenciacafej.entity.repository.PersonaRepository;
import com.agenciacafespring.agenciacafej.entity.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoServiceImplement implements ProductoService {
    private final ProductoRepository productoRepository;
    private final PersonaRepository personaRepository;


    @Override
    public List<Producto> getListProducto() {
        return productoRepository.listProducto();
    }

    @Override
    public void deleteProducto(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public ProductoResponse searchProducto(Long id) {
        Producto producto = productoRepository.searchProducto(id);
        return  Objects.nonNull(producto) ?
                buildProductoResponse(producto) :
                ProductoResponse.builder().build();
    }

    @Override
    public void saveProducto(ProductoRequest productoRequest) {
        Producto producto = new Producto();
        Categoria categoria = new Categoria();
        if(Objects.nonNull(productoRequest)){
            categoria.setId(productoRequest.getFk_categoria());
            producto.setId(productoRequest.getId());
            producto.setPeso(productoRequest.getPeso());
            producto.setCantidad(productoRequest.getCantidad());
            producto.setNombreProducto(productoRequest.getNombreProducto());
            producto.setFk_categoria(categoria);
            productoRepository.save(producto);
        }
    }

    @Override
    public void updateProducto(ProductoRequest productoRequest) {
        if(Objects.nonNull(productoRequest)){
            Optional<Producto> producto = productoRepository.findById(productoRequest.getId());
            if(producto.isPresent()){
                Producto productotoActualizar = buildProductoEntity(productoRequest);
                productoRepository.save(productotoActualizar);
            }
        }
    }

    private static Producto buildProductoEntity(ProductoRequest productoRequest) {
         return Producto.builder()
                .id(productoRequest.getId())
                .cantidad(productoRequest.getCantidad())
                .nombreProducto(productoRequest.getNombreProducto())
                .peso(productoRequest.getPeso())
                .fk_categoria(builCategoriaEntity(productoRequest))
                .build();
    }
    private static Categoria builCategoriaEntity(ProductoRequest productoRequest) {
        return Categoria.builder()
                .id(productoRequest.getFk_categoria())
                .build();
    }

    private static ProductoResponse buildProductoResponse(Producto producto) {
        return ProductoResponse.builder()
                .id(producto.getId())
                .peso(producto.getPeso())
                .cantidad(producto.getCantidad())
                .fk_categoria(buildCategoriaResponse(producto.getFk_categoria()).getId())
                .build();
    }

    private static Categoria buildCategoriaResponse(Categoria categoria){
        return Categoria.builder()
                .id(categoria.getId())
                .nombreCategoria(categoria.getNombreCategoria())
                .build();
    }

}

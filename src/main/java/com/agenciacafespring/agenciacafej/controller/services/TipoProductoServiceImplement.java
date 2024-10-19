package com.agenciacafespring.agenciacafej.controller.services;

import com.agenciacafespring.agenciacafej.controller.request.TipoProductoRequest;
import com.agenciacafespring.agenciacafej.controller.response.TipoProductoResponse;
import com.agenciacafespring.agenciacafej.controller.services.service.TipoProductoService;
import com.agenciacafespring.agenciacafej.entity.Producto;
import com.agenciacafespring.agenciacafej.entity.TipoProducto;
import com.agenciacafespring.agenciacafej.entity.repository.TipoProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TipoProductoServiceImplement implements TipoProductoService {
    private final TipoProductoRepository tipoProductoRepository;
    @Override
    public List<TipoProducto> getListTipoProducto() {
        return tipoProductoRepository.listTipoProducto();
    }

    @Override
    public void deleteTipoProducto(Long id) {
        tipoProductoRepository.deleteById(id);
    }

    @Override
    public TipoProductoResponse searchTipoProducto(Long id) {
        TipoProducto tipoProducto = tipoProductoRepository.searchTipoProducto(id);
        return  Objects.nonNull(tipoProducto) ?
                buildTipoProductoResponse(tipoProducto) :
                TipoProductoResponse.builder().build();
    }


    @Override
    public void saveTipoProducto(TipoProductoRequest tipoProductoRequest) {
        Producto producto = new Producto();
        TipoProducto tipoProducto = new TipoProducto();
        if(Objects.nonNull(tipoProductoRequest)) {
            producto.setId(tipoProducto.getFk_producto().getId());
            tipoProducto.setId(tipoProductoRequest.getId());
            tipoProducto.setNombreVariedad(tipoProducto.getNombreVariedad());
            tipoProducto.setFk_producto(producto);
            tipoProductoRepository.save(tipoProducto);
        }
    }

    @Override
    public void updateTipoProducto(TipoProductoRequest tipoProductoRequest) {
        if(Objects.nonNull(tipoProductoRequest)){
            Optional<TipoProducto> tipoProducto = tipoProductoRepository.findById(tipoProductoRequest.getId());
            if(tipoProducto.isPresent()){
                TipoProducto tipoProductoActuaizado = buildTipoProductosEntity(tipoProductoRequest);
                tipoProductoRepository.save(tipoProductoActuaizado);
            }
        }
    }

    private static TipoProductoResponse buildTipoProductoResponse(TipoProducto tipoProducto){
        return TipoProductoResponse.builder()
                .id(tipoProducto.getId())
                .nombreVariedad(tipoProducto.getNombreVariedad())
                .fk_producto(buildProductoResponse(tipoProducto.getFk_producto()).getId())
                .build();
    }

    private static Producto buildProductoResponse(Producto producto){
        return Producto.builder()
                .id(producto.getId())
                .nombreProducto(producto.getNombreProducto())
                .peso(producto.getPeso())
                .cantidad(producto.getCantidad())
                .fk_categoria(producto.getFk_categoria())
                .build();
    }



    private static TipoProducto buildTipoProductosEntity(TipoProductoRequest tipoProductoRequest) {
        return TipoProducto.builder()
                .id(tipoProductoRequest.getId())
                .nombreVariedad(tipoProductoRequest.getNombreVariedad())
                .fk_producto(buildProductoEntity(tipoProductoRequest))
                .build();
    }

    private static Producto buildProductoEntity(TipoProductoRequest tipoProductoRequest) {
        return Producto.builder()
                .id(tipoProductoRequest.getFk_producto())
                .build();
    }

}

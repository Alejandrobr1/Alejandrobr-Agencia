package com.agenciacafespring.agenciacafej.controller.services;

import com.agenciacafespring.agenciacafej.controller.request.CompraRequest;
import com.agenciacafespring.agenciacafej.controller.response.CompraResponse;
import com.agenciacafespring.agenciacafej.controller.services.service.CompraService;
import com.agenciacafespring.agenciacafej.entity.Compra;
import com.agenciacafespring.agenciacafej.entity.TipoProducto;
import com.agenciacafespring.agenciacafej.entity.repository.CompraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompraServiceImplement implements CompraService {
    private final CompraRepository compraRepository;

    @Override
    public List<Compra> getListCompra() {
        return compraRepository.listCompra();
    }

    @Override
    public void deleteCompra(Long id) {
        compraRepository.deleteById(id);
    }

    @Override
    public CompraResponse searchCompra(Long id) {
        Compra compra = compraRepository.searchCompra(id);

        return  Objects.nonNull(compra) ?
                buildCompraResponse(compra) :
                CompraResponse.builder().build();
    }

    @Override
    public void saveCompra(CompraRequest compraRequest) {
        Compra compra = new Compra();
        TipoProducto tipoProducto = new TipoProducto();
        if(Objects.nonNull(compraRequest)){
            tipoProducto.setId(compraRequest.getFk_tipo_productoc());
            compra.setCostoCompra(compraRequest.getCostoCompra());
            compra.setCantidadCompra(compraRequest.getCantidadCompra());
            compra.setFechaCompra(compraRequest.getFechaCompra());
            compra.setLugarCompra(compraRequest.getLugarCompra());
            compra.setCostoTotal(compraRequest.getCostoTotal());
            compra.setFk_tipo_productoc(tipoProducto);
            compraRepository.save(compra);
        }
    }

    @Override
    public void updateCompra(CompraRequest compraRequest) {
        if(Objects.nonNull(compraRequest)){
            Optional<Compra> compra = compraRepository.findById(compraRequest.getId());
            if(compra.isPresent()){
                Compra compraActualizar = buildCompraEntity(compraRequest);
                compraRepository.save(compraActualizar);
            }
        }
    }
    private static CompraResponse buildCompraResponse(Compra compra) {
        return CompraResponse.builder()
                .id(compra.getId())
                .costoCompra(compra.getCostoCompra())
                .cantidadCompra(compra.getCantidadCompra())
                .fechaCompra(compra.getFechaCompra())
                .lugarCompra(compra.getLugarCompra())
                .costoTotal(compra.getCostoTotal())
                .fk_tipo_productoc(buildTipoProductocResponse(compra.getFk_tipo_productoc()).getId())
                .build();
    }

    private static Compra buildCompraEntity(CompraRequest compraRequest) {
        return Compra.builder()
                .id(compraRequest.getId())
                .costoCompra(compraRequest.getCostoCompra())
                .cantidadCompra(compraRequest.getCantidadCompra())
                .fechaCompra(compraRequest.getFechaCompra())
                .lugarCompra(compraRequest.getLugarCompra())
                .costoTotal(compraRequest.getCostoTotal())
                .fk_tipo_productoc(buildTipoProductosEntity(compraRequest))
                .build();
    }
    private static TipoProducto buildTipoProductocResponse(TipoProducto tipoProducto){
        return TipoProducto.builder()
                .id(tipoProducto.getId())
                .nombreVariedad(tipoProducto.getNombreVariedad())
                .fk_producto(tipoProducto.getFk_producto())
                .build();
    }

    private static TipoProducto buildTipoProductosEntity(CompraRequest compraRequest) {
        return TipoProducto.builder()
                .id(compraRequest.getFk_tipo_productoc())
                .build();
    }
}

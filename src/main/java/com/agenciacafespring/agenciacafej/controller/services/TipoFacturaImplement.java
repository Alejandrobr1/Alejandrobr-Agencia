package com.agenciacafespring.agenciacafej.controller.services;

import com.agenciacafespring.agenciacafej.controller.request.TipoFacturaRequest;
import com.agenciacafespring.agenciacafej.controller.response.TipoFacturaResponse;
import com.agenciacafespring.agenciacafej.controller.services.service.TipoFacturaService;
import com.agenciacafespring.agenciacafej.entity.*;
import com.agenciacafespring.agenciacafej.entity.repository.TipoFacturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TipoFacturaImplement implements TipoFacturaService {
    private final TipoFacturaRepository tipoFacturaRepository;
    @Override
    public List<TipoFactura> getListTipoFactura() {
        return tipoFacturaRepository.listTipoFactura();
    }

    @Override
    public void deleteTipoFactura(Long id) {
        tipoFacturaRepository.deleteById(id);
    }

    @Override
    public TipoFacturaResponse searchTipoFactura(Long id) {
        TipoFactura tipoFactura = tipoFacturaRepository.searchTipoFactura(id);
        return  Objects.nonNull(tipoFactura) ?
                buildTipoFacturaResponse(tipoFactura) :
                TipoFacturaResponse.builder().build();
    }

    @Override
    public void saveTipoFactura(TipoFacturaRequest tipoFacturaRequest) {
        TipoFactura tipoFactura = new TipoFactura();
        Compra compra = new Compra();
        Venta venta = new Venta();

        if(Objects.nonNull(tipoFacturaRequest)) {
            venta.setId(tipoFacturaRequest.getFk_venta());
            compra.setId(tipoFacturaRequest.getFk_compra());
            tipoFactura.setCategoriaFactura(tipoFacturaRequest.getCategoriaFactura());
            tipoFactura.setFk_compra(compra);
            tipoFactura.setFk_venta(venta);
            tipoFacturaRepository.save(tipoFactura);
        }
    }

    @Override
    public void updateTipoFactura(TipoFacturaRequest tipoFacturaRequest) {
        if(Objects.nonNull(tipoFacturaRequest)){
            Optional<TipoFactura> tipoFactura = tipoFacturaRepository.findById(tipoFacturaRequest.getId());
            if(tipoFactura.isPresent()){
                TipoFactura tipoFacturaActualizado = buildTipoFacturaEntity(tipoFacturaRequest);
                tipoFacturaRepository.save(tipoFacturaActualizado);
            }
        }
    }

    private static TipoFacturaResponse buildTipoFacturaResponse(TipoFactura tipoFactura) {
        return TipoFacturaResponse.builder()
                .id(tipoFactura.getId())
                .categoriaFactura(tipoFactura.getCategoriaFactura())
                .fk_compra(buildCompraRolResponse(tipoFactura.getFk_compra()).getId())
                .fk_venta(buildVentaRolResponse(tipoFactura.getFk_venta()).getId())
                .build();
    }

    private static Compra buildCompraRolResponse(Compra compra) {
        return Compra.builder()
                .id(compra.getId())
                .lugarCompra(compra.getLugarCompra())
                .fechaCompra(compra.getFechaCompra())
                .cantidadCompra(compra.getCantidadCompra())
                .costoCompra(compra.getCostoCompra())
                .costoTotal(compra.getCostoTotal())
                .build();
    }
    private static Venta buildVentaRolResponse(Venta venta) {
        return Venta.builder()
                .id(venta.getId())
                .descuento(venta.getDescuento())
                .lugarVenta(venta.getLugarVenta())
                .fechaVenta(venta.getFechaVenta())
                .cantidadVenta(venta.getCantidadVenta())
                .costoVenta(venta.getCostoVenta())
                .costoTotal(venta.getCostoTotal())
                .build();
    }

    private static TipoFactura buildTipoFacturaEntity(TipoFacturaRequest tipoFacturaRequest) {
        return TipoFactura.builder()
                .id(tipoFacturaRequest.getId())
                .categoriaFactura(tipoFacturaRequest.getCategoriaFactura())
                .fk_venta(buildVentaEntity(tipoFacturaRequest))
                .fk_compra(buildCompraEntity(tipoFacturaRequest))
                .build();
    }

    private static Venta buildVentaEntity(TipoFacturaRequest tipoFacturaRequest) {
        return Venta.builder()
                .id(tipoFacturaRequest.getFk_venta())
                .build();
    }

    private static Compra buildCompraEntity(TipoFacturaRequest tipoFacturaRequest) {
        return Compra.builder()
                .id(tipoFacturaRequest.getFk_compra())
                .build();
    }

}

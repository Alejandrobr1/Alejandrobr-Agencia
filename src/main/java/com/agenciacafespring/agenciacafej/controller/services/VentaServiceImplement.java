package com.agenciacafespring.agenciacafej.controller.services;

import com.agenciacafespring.agenciacafej.controller.request.VentaRequest;
import com.agenciacafespring.agenciacafej.controller.response.VentaResponse;
import com.agenciacafespring.agenciacafej.controller.services.service.VentaService;
import com.agenciacafespring.agenciacafej.entity.TipoProducto;
import com.agenciacafespring.agenciacafej.entity.Venta;
import com.agenciacafespring.agenciacafej.entity.repository.VentaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VentaServiceImplement implements VentaService {
    private final VentaRepository ventaRepository;
    @Override
    public List<Venta> getListaVenta() {
        return ventaRepository.listVenta();
    }

    @Override
    public void deleteVenta(Long id) {
        ventaRepository.deleteById(id);
    }

    @Override
    public VentaResponse searchVenta(Long id) {
        Venta venta= ventaRepository.searchVenta(id);
        return  Objects.nonNull(venta) ?
                buildVentaResponse(venta) :
                VentaResponse.builder().build();
    }

    @Override
    public void saveVenta(VentaRequest ventaRequest) {
        Venta venta = new Venta();
        TipoProducto tipoProducto = new TipoProducto();
        if(Objects.nonNull(ventaRequest)){
            tipoProducto.setId(ventaRequest.getFk_tipo_producto());
            venta.setCostoVenta(ventaRequest.getCostoVenta());
            venta.setCantidadVenta(ventaRequest.getCantidadVenta());
            venta.setFechaVenta(ventaRequest.getFechaVenta());
            venta.setLugarVenta(ventaRequest.getLugarVenta());
            venta.setCostoTotal(ventaRequest.getCostoTotal());
            venta.setDescuento(ventaRequest.getDescuento());
            venta.setFk_tipo_producto(tipoProducto);
            ventaRepository.save(venta);
        }
    }

    @Override
    public void updateVenta(VentaRequest ventaRequest) {
        if(Objects.nonNull(ventaRequest)){
            Optional<Venta> venta = ventaRepository.findById(ventaRequest.getId());
            if(venta.isPresent()){
                Venta ventaActualizar = buildVentaEntity(ventaRequest);
                ventaRepository.save(ventaActualizar);
            }
        }
    }
    private static VentaResponse buildVentaResponse(Venta venta) {
        return VentaResponse.builder()
                .id(venta.getId())
                .costoVenta(venta.getCostoVenta())
                .cantidadVenta(venta.getCantidadVenta())
                .fechaVenta(venta.getFechaVenta())
                .lugarVenta(venta.getLugarVenta())
                .costoTotal(venta.getCostoTotal())
                .descuento(venta.getDescuento())
                .fk_tipo_producto(buildTipoProductocResponse(venta.getFk_tipo_producto()).getId())
                .build();
    }

    private static Venta buildVentaEntity(VentaRequest ventaRequest) {
        return Venta.builder()
                .id(ventaRequest.getId())
                .costoVenta(ventaRequest.getCostoVenta())
                .cantidadVenta(ventaRequest.getCantidadVenta())
                .fechaVenta(ventaRequest.getFechaVenta())
                .lugarVenta(ventaRequest.getLugarVenta())
                .costoTotal(ventaRequest.getCostoTotal())
                .descuento(ventaRequest.getDescuento())
                .fk_tipo_producto(buildTipoProductosEntity(ventaRequest))
                .build();
    }
    private static TipoProducto buildTipoProductocResponse(TipoProducto tipoProducto){
        return TipoProducto.builder()
                .id(tipoProducto.getId())
                .nombreVariedad(tipoProducto.getNombreVariedad())
                .fk_producto(tipoProducto.getFk_producto())
                .build();
    }

    private static TipoProducto buildTipoProductosEntity(VentaRequest ventaRequest) {
        return TipoProducto.builder()
                .id(ventaRequest.getFk_tipo_producto())
                .build();
    }
}


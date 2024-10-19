package com.agenciacafespring.agenciacafej.controller.services;

import com.agenciacafespring.agenciacafej.controller.request.FacturaRequest;
import com.agenciacafespring.agenciacafej.controller.response.FacturaResponse;
import com.agenciacafespring.agenciacafej.controller.services.service.FacturaService;
import com.agenciacafespring.agenciacafej.entity.*;
import com.agenciacafespring.agenciacafej.entity.repository.FacturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FacturaServiceImplement implements FacturaService {
    private final FacturaRepository facturaRepository;
    @Override
    public List<Factura> getListaFactura() {
        return facturaRepository.listFactura();
    }

    @Override
    public void deleteFactura(Long id) {
        facturaRepository.deleteById(id);
    }

    @Override
    public FacturaResponse searchFactura(Long id) {
        Factura factura = facturaRepository.searchFactura(id);
        return Objects.nonNull(factura)?
            buildFacturaResponse(factura):
            FacturaResponse.builder().build();

    }

    @Override
    public void saveFactura(FacturaRequest facturaRequest) {
        TipoFactura tipoFactura = new TipoFactura();
        Persona persona = new Persona();
        Factura factura = new Factura();
        if (Objects.nonNull(facturaRequest)) {
                    tipoFactura.setId(facturaRequest.getFk_tipo_factura());
                    persona.setId(facturaRequest.getFk_persona());
                    factura.setId(facturaRequest.getId());
                    factura.setFechaFactura(facturaRequest.getFechaFactura());
                    factura.setTipoPago(facturaRequest.getTipoPago());
                    factura.setFk_persona(persona);
                    factura.setFk_tipo_factura(tipoFactura);


                    facturaRepository.save(factura);
        }

    }

    @Override
    public void updateFactura(FacturaRequest facturaRequest) {
       
        if (Objects.nonNull(facturaRequest)) {
            Optional<Factura> factura = facturaRepository.findById(facturaRequest.getId());
            if (factura.isPresent()) {
                    Factura facturaActualizada = buildFacturaEntity(facturaRequest);
                        

                    facturaRepository.save(facturaActualizada);
            }
            
        }
    }
    

    private static Factura buildFacturaEntity(FacturaRequest facturaRequest) {
        return Factura.builder()
                .id(facturaRequest.getId())
                .fechaFactura(facturaRequest.getFechaFactura())
                .tipoPago(facturaRequest.getTipoPago())
                .fk_tipo_factura(buildTipoFacturaEntity(facturaRequest))
                .fk_persona(buildPersonasEntity(facturaRequest))
                .build();
    }
    private static TipoFactura buildTipoFacturaEntity(FacturaRequest facturaRequest) {
        return TipoFactura.builder()
                .id(facturaRequest.getFk_tipo_factura())
                .build();
    }
    private static Persona buildPersonasEntity(FacturaRequest facturaRequest) {
        return Persona.builder()
                .id(facturaRequest.getFk_persona())
                .build();
    }

    private static FacturaResponse buildFacturaResponse(Factura factura) {
        return FacturaResponse.builder()
                .id(factura.getId())
                .fechaFactura(factura.getFechaFactura())
                .tipoPago(factura.getTipoPago())
                .fk_tipo_factura(buildTipoFacturaResponse(factura.getFk_tipo_factura()).getId())
                .fk_persona(buildPersonaResponse(factura.getFk_persona()).getId())
                .build();
    }

    private static TipoFactura buildTipoFacturaResponse(TipoFactura tipoFactura){
        return TipoFactura.builder()
                .id(tipoFactura.getId())
                .categoriaFactura(tipoFactura.getCategoriaFactura())
                .fk_compra(tipoFactura.getFk_compra())
                .fk_venta(tipoFactura.getFk_venta())
                .build();
    }
    private static Persona buildPersonaResponse(Persona persona){
        return Persona.builder()
                .id(persona.getId())
                .nombre(persona.getNombre())
                .estadoSistema(persona.getEstadoSistema())
                .fechaNacimiento(persona.getFechaNacimiento())
                .apellido(persona.getApellido())
                .lugarNacimiento(persona.getLugarNacimiento())
                .build();
    }


}

package com.agenciacafespring.agenciacafej.controller.services;

import com.agenciacafespring.agenciacafej.controller.request.TipoDocumentoRequest;
import com.agenciacafespring.agenciacafej.controller.response.TipoDocumentoResponse;
import com.agenciacafespring.agenciacafej.controller.services.service.TipoDocumentoService;
import com.agenciacafespring.agenciacafej.entity.TipoDocumento;
import com.agenciacafespring.agenciacafej.entity.repository.TipoDocumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TipoDocumentoServiceImplement implements TipoDocumentoService {
    private final TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    public List<TipoDocumento> getListTipoDocumento() {
        return tipoDocumentoRepository.listTipoDocumento();
    }

    @Override
    public void deleteTipoDocumento(Long id) {
        tipoDocumentoRepository.deleteById(id);
    }

    @Override
    public TipoDocumentoResponse searchTipoDocumento(Long id) {
        TipoDocumento tipoDocumento = tipoDocumentoRepository.searchTipoDocumento(id);
        if(Objects.nonNull(tipoDocumento)){
            return TipoDocumentoResponse.builder()
                    .id(tipoDocumento.getId())
                    .sigla(tipoDocumento.getSigla())
                    .descripcion(tipoDocumento.getDescripcion())
                    .build();
        }
        return TipoDocumentoResponse.builder().build();
    }

    @Override
    public void saveTipoDocumento(TipoDocumentoRequest tipoDocumentoRequest) {
        if(Objects.nonNull(tipoDocumentoRequest)){
            TipoDocumento tipoDocumento = TipoDocumento.builder()
                    .sigla(tipoDocumentoRequest.getSigla())
                    .descripcion(tipoDocumentoRequest.getDescripcion())
                    .build();
            tipoDocumentoRepository.save(tipoDocumento);
        }
    }

    @Override
    public void updateTipoDocumento(TipoDocumentoRequest tipoDocumentoRequest) {
        if(Objects.nonNull(tipoDocumentoRequest)){
            TipoDocumento tipoDocumento = TipoDocumento.builder()
                    .sigla(tipoDocumentoRequest.getSigla())
                    .descripcion(tipoDocumentoRequest.getDescripcion())
                    .build();
            tipoDocumentoRepository.save(tipoDocumento);
        }
    }
}

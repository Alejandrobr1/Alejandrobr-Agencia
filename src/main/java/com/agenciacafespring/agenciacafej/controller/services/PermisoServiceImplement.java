package com.agenciacafespring.agenciacafej.controller.services;

import com.agenciacafespring.agenciacafej.controller.request.PermisoRequest;
import com.agenciacafespring.agenciacafej.controller.response.PermisoResponse;
import com.agenciacafespring.agenciacafej.controller.response.RolResponse;
import com.agenciacafespring.agenciacafej.controller.services.service.PermisoService;
import com.agenciacafespring.agenciacafej.entity.*;
import com.agenciacafespring.agenciacafej.entity.repository.PermisoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PermisoServiceImplement implements PermisoService {
    private final PermisoRepository permisoRepository;
    @Override
    public List<Permiso> getListPermiso() {
        return permisoRepository.listPermiso();
    }

    @Override
    public void deletePermiso(Long id) {
        permisoRepository.deleteById(id);
    }

    @Override
    public PermisoResponse searchPermiso(Long id) {
        Permiso permiso = permisoRepository.searchPermiso(id);
        if(Objects.isNull(permiso)) {
            return buildPermisoResponse(permiso);
        }
        return PermisoResponse.builder().build();
    }



    @Override
    public void savePermiso(PermisoRequest permisoRequest) {
        Permiso permiso = new Permiso();
        Rol rol = new Rol();
        if (Objects.nonNull(permisoRequest.getId())) {
            rol.setId(permisoRequest.getId());
            permiso.setId(permisoRequest.getId());
            permiso.setTipoPermiso(permisoRequest.getTipoPermiso());
            permiso.setFk_rol(rol);
            permisoRepository.save(permiso);
        }

    }

    @Override
    public void updatePermiso(PermisoRequest permisoRequest) {
        if(Objects.nonNull(permisoRequest)){
            Optional<Permiso> permiso = permisoRepository.findById(permisoRequest.getId());
            if(permiso.isPresent()){
                Permiso permisoActualizado = buildPermisoEntity(permisoRequest);
                permisoRepository.save(permisoActualizado);
            }
        }
    }
    private static Permiso buildPermisoEntity(PermisoRequest permisoRequest) {
        return Permiso.builder()
                .id(permisoRequest.getId())
                .tipoPermiso(permisoRequest.getTipoPermiso())
                .fk_rol(buildRolEntity(permisoRequest))
                .build();
    }
    private static Rol buildRolEntity(PermisoRequest permisoRequest) {
        return Rol.builder()
                .id(permisoRequest.getFk_rol())
                .build();
    }

    private static PermisoResponse buildPermisoResponse(Permiso permiso) {
        return PermisoResponse.builder()
                .id(permiso.getId())
                .tipoPermiso(permiso.getTipoPermiso())
                .fk_rol(buildRolResponse(permiso.getFk_rol()).getId())
                .build();
    }

    private static RolResponse buildRolResponse(Rol rol) {
        return RolResponse.builder()
                .id(rol.getId())
                .nombreRol(rol.getNombreRol())
                .fk_persona_rol(rol.getFk_persona_rol().getId())
                .build();
    }
}

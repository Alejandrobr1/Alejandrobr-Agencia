package com.agenciacafespring.agenciacafej.controller.services;

import com.agenciacafespring.agenciacafej.controller.request.RolRequest;
import com.agenciacafespring.agenciacafej.controller.response.RolResponse;
import com.agenciacafespring.agenciacafej.controller.services.service.RolService;
import com.agenciacafespring.agenciacafej.entity.*;
import com.agenciacafespring.agenciacafej.entity.repository.RolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RolServiceImplement implements RolService {
    private final RolRepository rolRepository;
    @Override
    public List<Rol> getListRol() {
        return rolRepository.listRol();
    }

    @Override
    public void deleteRol(Long id) {
        rolRepository.deleteById(id);
    }

    @Override
    public RolResponse searchRol(Long id) {
        Rol rol = rolRepository.searchRol(id);
        return  Objects.nonNull(rol) ?
                buildRolResponse(rol) :
                RolResponse.builder().build();
    }


    @Override
    public void saveRol(RolRequest rolRequest) {
        Rol rol = new Rol();
        Persona persona = new Persona();
        if(Objects.nonNull(rolRequest)){
            persona.setId(rolRequest.getFk_persona_rol());
            rol.setId(rolRequest.getId());
            rol.setNombreRol(rolRequest.getNombreRol());
            rol.setFk_persona_rol(persona);
            rolRepository.save(rol);
        }
    }

    @Override
    public void updateRol(RolRequest rolRequest) {
        if(Objects.nonNull(rolRequest)){
            Optional<Rol> rol = rolRepository.findById(rolRequest.getId());
            if(rol.isPresent()){
                Rol rolActualizado = buildRolEntity(rolRequest);
                rolRepository.save(rolActualizado);
            }
        }

    }

    private static Rol buildRolEntity(RolRequest rolRequest) {
        return Rol.builder()
                .id(rolRequest.getId())
                .nombreRol(rolRequest.getNombreRol())
                .fk_persona_rol(builPersonaRolEntity(rolRequest))
                .build();
    }
    private static Persona builPersonaRolEntity(RolRequest rolRequest) {
        return Persona.builder()
                .id(rolRequest.getFk_persona_rol())
                .build();
    }

    private static RolResponse buildRolResponse(Rol rol) {
        return RolResponse.builder()
                .id(rol.getId())
                .nombreRol(rol.getNombreRol())
                .fk_persona_rol(buildPersonaRolResponse(rol.getFk_persona_rol()).getId())
                .build();
    }

    private static Persona buildPersonaRolResponse(Persona persona) {
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

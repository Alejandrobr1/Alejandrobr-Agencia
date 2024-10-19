package com.agenciacafespring.agenciacafej.controller.services;

import com.agenciacafespring.agenciacafej.controller.request.PersonaRequest;
import com.agenciacafespring.agenciacafej.controller.response.PersonaResponse;
import com.agenciacafespring.agenciacafej.controller.services.service.PersonaService;
import com.agenciacafespring.agenciacafej.entity.Persona;
import com.agenciacafespring.agenciacafej.entity.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PersonaServiceImplement implements PersonaService {

    private final PersonaRepository personaRepository;

    @Override
    public void deletePerson(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public PersonaResponse searchPerson(Long id) {
        Persona persona = personaRepository.searchPerson(id);
        if(Objects.nonNull(persona)){
            return PersonaResponse.builder()
                    .id(persona.getId())
                    .nombre(persona.getNombre())
                    .apellido(persona.getApellido())
                    .fechaNacimiento(persona.getFechaNacimiento())
                    .lugarNacimiento(persona.getLugarNacimiento())
                    .estadoSistema(persona.getEstadoSistema())
                    .build();
        }
        return PersonaResponse.builder().build();
    }

    @Override
    public void savePerson(PersonaRequest personaRequest) {
        if(Objects.nonNull(personaRequest)){
            Persona persona = Persona.builder()
                    .nombre(personaRequest.getNombre())
                    .apellido(personaRequest.getApellido())
                    .fechaNacimiento(personaRequest.getFechaNacimiento())
                    .lugarNacimiento(personaRequest.getLugarNacimiento())
                    .estadoSistema(personaRequest.getEstadoSistema())
                    .build();

            personaRepository.save(persona);
        }
    }

    @Override
    public void updatePerson(PersonaRequest personaRequest) {
        if(Objects.nonNull(personaRequest)){
            Persona persona = Persona.builder()
                    .nombre(personaRequest.getNombre())
                    .apellido(personaRequest.getApellido())
                    .fechaNacimiento(personaRequest.getFechaNacimiento())
                    .lugarNacimiento(personaRequest.getLugarNacimiento())
                    .estadoSistema(personaRequest.getEstadoSistema())
                    .build();

            personaRepository.save(persona);
        }
    }

    @Override
    public List<Persona> getlistPersona() {
        return personaRepository.listPerson();
    }


}



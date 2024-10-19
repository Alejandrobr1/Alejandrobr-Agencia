package com.agenciacafespring.agenciacafej.controller.services.service;

import com.agenciacafespring.agenciacafej.controller.request.PersonaRequest;
import com.agenciacafespring.agenciacafej.controller.response.PersonaResponse;
import com.agenciacafespring.agenciacafej.entity.Persona;

import java.util.List;

public interface PersonaService {
    List<Persona> getlistPersona(); //este es el que se expone al controlador
    void deletePerson(Long id);
    PersonaResponse searchPerson(Long id);
    void savePerson(PersonaRequest personaRequest);
    void updatePerson(PersonaRequest personaRequest);


}

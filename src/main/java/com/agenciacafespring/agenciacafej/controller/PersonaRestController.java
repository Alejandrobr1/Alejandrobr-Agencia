package com.agenciacafespring.agenciacafej.controller;

import com.agenciacafespring.agenciacafej.controller.response.PersonaResponse;
import com.agenciacafespring.agenciacafej.controller.request.PersonaRequest;
import com.agenciacafespring.agenciacafej.controller.services.service.PersonaService;
import com.agenciacafespring.agenciacafej.entity.Persona;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("person/v1")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class PersonaRestController {
    private final PersonaService personaService;

    @GetMapping("/list")
    public ResponseEntity<List<Persona>> listPersonsApi() {
        List<Persona> personaList = personaService.getlistPersona();
        return new ResponseEntity<>(personaList, HttpStatus.ACCEPTED); }

    @GetMapping("/delete")
    public ResponseEntity<Map<String, String>> deletePersonsApi(@RequestParam(name = "id") Long id) {
        personaService.deletePerson(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "La acción solicitada se realizó");
        return ResponseEntity.accepted().body(response);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Map<String, Object>> searchPersonsApi(@PathVariable Long id) {
        PersonaResponse personaResponse = personaService.searchPerson(id);
        Map<String, Object> response = new HashMap<>();
        response.put("persona", personaResponse);
        response.put("message", "La acción solicitada se realizó");
        return ResponseEntity.accepted().body(response);
    }

    @PostMapping("/save")
    public ResponseEntity<Map<String, String>> savePersonsApi(@RequestBody PersonaRequest personaRequest) {
        personaService.savePerson(personaRequest);
        Map<String, String> response = new HashMap<>();
        response.put("message", "La acción solicitada se realizó");
        return ResponseEntity.accepted().body(response);
    }

    @PostMapping("/update")
    public ResponseEntity<Map<String, String>> updatePersonsApi(@RequestBody PersonaRequest personaRequest) {
        personaService.updatePerson(personaRequest);
        Map<String, String> response = new HashMap<>();
        response.put("message", "La acción solicitada se realizó");
        return ResponseEntity.accepted().body(response);
    }
}

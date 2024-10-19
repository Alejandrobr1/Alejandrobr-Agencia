package com.agenciacafespring.agenciacafej.controller;

import com.agenciacafespring.agenciacafej.controller.request.DocumentoRequest;
import com.agenciacafespring.agenciacafej.controller.response.DocumentoResponse;
import com.agenciacafespring.agenciacafej.controller.services.service.DocumentoService;
import com.agenciacafespring.agenciacafej.entity.Documento;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("documento/v1")
@RequiredArgsConstructor
public class DocumentoRestController {
    private final DocumentoService documentoService;

    @GetMapping("/list")
    public ResponseEntity<List<Documento>> listDocumento() {
        List<Documento> documentoList = documentoService.getListDocumento();
        return new ResponseEntity<>(documentoList, HttpStatus.ACCEPTED);
    }


    @GetMapping("/delete")
    public ResponseEntity<String> deleteDocumento(@RequestParam(name = "id") Long id ){
        documentoService.deleteDocumento(id);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<DocumentoResponse>  searchDocumento(@PathVariable Long id){
        DocumentoResponse documentoResponse =  documentoService.searchDocumento(id);
        return ResponseEntity.accepted().body(documentoResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveDocumento(@RequestBody DocumentoRequest documentoRequest){
        documentoService.saveDocumento(documentoRequest);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateDocumento(@RequestBody DocumentoRequest documentoRequest){
        documentoService.updateDocumento(documentoRequest);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }
}

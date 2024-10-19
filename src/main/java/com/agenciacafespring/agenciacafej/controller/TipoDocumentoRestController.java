package com.agenciacafespring.agenciacafej.controller;

import com.agenciacafespring.agenciacafej.controller.request.TipoDocumentoRequest;
import com.agenciacafespring.agenciacafej.controller.response.TipoDocumentoResponse;
import com.agenciacafespring.agenciacafej.controller.services.service.TipoDocumentoService;
import com.agenciacafespring.agenciacafej.entity.TipoDocumento;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tipoDocumnento/v1")
@RequiredArgsConstructor
public class TipoDocumentoRestController {
    private final TipoDocumentoService tipoDocumentoService;


    @GetMapping("/List")
    public ResponseEntity<List<TipoDocumento>> listTipoDocumento() {
        List<TipoDocumento> tipoDocumentoList=tipoDocumentoService.getListTipoDocumento();
        return ResponseEntity.accepted().body(tipoDocumentoList);
    }

    @GetMapping("/delete")
    public ResponseEntity<String> deleteTipoDocumento(@RequestParam(name = "id") Long id ){
        tipoDocumentoService.deleteTipoDocumento(id);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }


    @PostMapping("/update")
    public ResponseEntity<String> updateTipoDocumentoApi(@RequestBody TipoDocumentoRequest tipoDocumentoRequest){
        tipoDocumentoService.updateTipoDocumento(tipoDocumentoRequest);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveTipoDocumentoApi(@RequestBody TipoDocumentoRequest tipoDocumentoRequest){
        tipoDocumentoService.saveTipoDocumento(tipoDocumentoRequest);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<TipoDocumentoResponse>  searchTipoDocumentos(@PathVariable Long id){
        TipoDocumentoResponse tipoDocumentoResponse =  tipoDocumentoService.searchTipoDocumento(id);
        return ResponseEntity.accepted().body(tipoDocumentoResponse);
    }
}

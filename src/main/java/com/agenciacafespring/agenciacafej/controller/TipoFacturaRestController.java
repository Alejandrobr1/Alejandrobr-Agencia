package com.agenciacafespring.agenciacafej.controller;

import com.agenciacafespring.agenciacafej.controller.request.TipoFacturaRequest;
import com.agenciacafespring.agenciacafej.controller.response.TipoFacturaResponse;
import com.agenciacafespring.agenciacafej.controller.services.service.TipoFacturaService;
import com.agenciacafespring.agenciacafej.entity.TipoFactura;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tipoFactura/v1")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class TipoFacturaRestController {
    private final TipoFacturaService tipoFacturaService;
    @GetMapping("/list")
    public ResponseEntity<List<TipoFactura>> listTipoFactura() {
        List<TipoFactura> tipoFacturaList = tipoFacturaService.getListTipoFactura();
        return new ResponseEntity<>(tipoFacturaList, HttpStatus.ACCEPTED);
    }


    @GetMapping("/delete")
    public ResponseEntity<String> deleteTipoFactura(@RequestParam(name = "id") Long id ){
        tipoFacturaService.deleteTipoFactura(id);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<TipoFacturaResponse>  searchTipoFactura(@PathVariable Long id){
        TipoFacturaResponse tipoFacturaResponse =  tipoFacturaService.searchTipoFactura(id);
        return ResponseEntity.accepted().body(tipoFacturaResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveTipoFactura(@RequestBody TipoFacturaRequest tipoFacturaRequest){
        tipoFacturaService.saveTipoFactura(tipoFacturaRequest);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateTipoFactura(@RequestBody TipoFacturaRequest tipoFacturaRequest){
        tipoFacturaService.updateTipoFactura(tipoFacturaRequest);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }
}

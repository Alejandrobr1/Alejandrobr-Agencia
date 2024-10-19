package com.agenciacafespring.agenciacafej.controller;


import com.agenciacafespring.agenciacafej.controller.request.TipoFacturaRequest;
import com.agenciacafespring.agenciacafej.controller.request.TipoProductoRequest;
import com.agenciacafespring.agenciacafej.controller.response.TipoFacturaResponse;
import com.agenciacafespring.agenciacafej.controller.response.TipoProductoResponse;
import com.agenciacafespring.agenciacafej.controller.services.service.TipoProductoService;
import com.agenciacafespring.agenciacafej.entity.TipoFactura;
import com.agenciacafespring.agenciacafej.entity.TipoProducto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tipoProducto/v1")
@RequiredArgsConstructor
public class TipoProductoRestController {
private final TipoProductoService tipoProductoService;
    @GetMapping("/list")
    public ResponseEntity<List<TipoProducto>> listTipoProducto() {
        List<TipoProducto> tipoProductoList = tipoProductoService.getListTipoProducto();
        return new ResponseEntity<>(tipoProductoList, HttpStatus.ACCEPTED);
    }


    @GetMapping("/delete")
    public ResponseEntity<String> deleteTipoProducto(@RequestParam(name = "id") Long id ){
        tipoProductoService.deleteTipoProducto(id);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<TipoProductoResponse>  searchTipoProducto(@PathVariable Long id){
        TipoProductoResponse tipoProductoResponse =  tipoProductoService.searchTipoProducto(id);
        return ResponseEntity.accepted().body(tipoProductoResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveTipoProducto(@RequestBody TipoProductoRequest tipoProductoRequest){
        tipoProductoService.saveTipoProducto(tipoProductoRequest);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateTipoProducto(@RequestBody TipoProductoRequest tipoProductoRequest){
        tipoProductoService.updateTipoProducto(tipoProductoRequest);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }
}

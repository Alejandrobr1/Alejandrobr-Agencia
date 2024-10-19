package com.agenciacafespring.agenciacafej.controller;

import com.agenciacafespring.agenciacafej.controller.request.VentaRequest;
import com.agenciacafespring.agenciacafej.controller.response.VentaResponse;
import com.agenciacafespring.agenciacafej.controller.services.service.VentaService;
import com.agenciacafespring.agenciacafej.entity.Venta;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("venta/v1")
@RequiredArgsConstructor
public class VentaRestController {
    private final VentaService ventaService;

    @GetMapping("/list")
    public ResponseEntity<List<Venta>> listVenta() {
        List<Venta> ventaList = ventaService.getListaVenta();
        return new ResponseEntity<>(ventaList, HttpStatus.ACCEPTED);
    }


    @GetMapping("/delete")
    public ResponseEntity<String> deleteVenta(@RequestParam(name = "id") Long id ){
        ventaService.deleteVenta(id);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<VentaResponse>  searchVenta(@PathVariable Long id){
        VentaResponse ventaResponse =  ventaService.searchVenta(id);
        return ResponseEntity.accepted().body(ventaResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveVenta(@RequestBody VentaRequest ventaRequest){
        ventaService.saveVenta(ventaRequest);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateVenta(@RequestBody VentaRequest ventaRequest){
        ventaService.updateVenta(ventaRequest);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }
}

package com.agenciacafespring.agenciacafej.controller;

import com.agenciacafespring.agenciacafej.controller.request.FacturaRequest;
import com.agenciacafespring.agenciacafej.controller.response.FacturaResponse;
import com.agenciacafespring.agenciacafej.controller.services.service.FacturaService;
import com.agenciacafespring.agenciacafej.entity.Factura;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("factura/v1")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class FacturaRestController {
    private final FacturaService facturaService;

    @GetMapping("/list")
    public ResponseEntity<List<Factura>> listFactura() {
        List<Factura> facturaList = facturaService.getListaFactura();
        return new ResponseEntity<>(facturaList, HttpStatus.ACCEPTED);
    }


    @GetMapping("/delete")
    public ResponseEntity<String> deleteFactura(@RequestParam(name = "id") Long id ){
        facturaService.deleteFactura(id);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<FacturaResponse>  searchFactura(@PathVariable Long id){
        FacturaResponse facturaResponse =  facturaService.searchFactura(id);
        return ResponseEntity.accepted().body(facturaResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveFactura(@RequestBody FacturaRequest facturaRequest){
        facturaService.saveFactura(facturaRequest);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateFactura(@RequestBody FacturaRequest facturaRequest){
        facturaService.updateFactura(facturaRequest);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }
}

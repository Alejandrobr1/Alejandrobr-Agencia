package com.agenciacafespring.agenciacafej.controller;

import com.agenciacafespring.agenciacafej.controller.request.CompraRequest;
import com.agenciacafespring.agenciacafej.controller.response.CompraResponse;
import com.agenciacafespring.agenciacafej.controller.services.service.CompraService;
import com.agenciacafespring.agenciacafej.entity.Compra;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("compra/v1")
@RequiredArgsConstructor
public class CompraRestController {
    private final CompraService compraService;

    @GetMapping("/list")
    public ResponseEntity<List<Compra>> listCompra() {
        List<Compra> compraList = compraService.getListCompra();
        return new ResponseEntity<>(compraList, HttpStatus.ACCEPTED);
    }


    @GetMapping("/delete")
    public ResponseEntity<String> deleteCompra(@RequestParam(name = "id") Long id ){
        compraService.deleteCompra(id);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<CompraResponse>  searchCompra(@PathVariable Long id){
        CompraResponse compraResponse =  compraService.searchCompra(id);
        return ResponseEntity.accepted().body(compraResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveCompra(@RequestBody CompraRequest compraRequest){
        compraService.saveCompra(compraRequest);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateCompra(@RequestBody CompraRequest compraRequest){
        compraService.updateCompra(compraRequest);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }
}

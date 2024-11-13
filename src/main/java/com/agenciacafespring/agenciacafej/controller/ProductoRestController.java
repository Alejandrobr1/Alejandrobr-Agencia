package com.agenciacafespring.agenciacafej.controller;

import com.agenciacafespring.agenciacafej.controller.request.ProductoRequest;
import com.agenciacafespring.agenciacafej.controller.response.ProductoResponse;
import com.agenciacafespring.agenciacafej.controller.services.service.ProductoService;
import com.agenciacafespring.agenciacafej.entity.Producto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("producto/v1")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ProductoRestController {
    private final ProductoService productoService;

    @GetMapping("/list")
    public ResponseEntity<List<Producto>> listProducto() {
        List<Producto> productoList = productoService.getListProducto();
        return new ResponseEntity<>(productoList, HttpStatus.ACCEPTED);
    }


    @GetMapping("/delete")
    public ResponseEntity<String> deleteProducto(@RequestParam(name = "id") Long id ){
        productoService.deleteProducto(id);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<ProductoResponse>  searchPersonsApi(@PathVariable Long id){
        ProductoResponse personaResponse =  productoService.searchProducto(id);
        return ResponseEntity.accepted().body(personaResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveProducto(@RequestBody ProductoRequest productoRequest){
        productoService.saveProducto(productoRequest);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateProducto(@RequestBody ProductoRequest productoRequest){
        productoService.updateProducto(productoRequest);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }
}

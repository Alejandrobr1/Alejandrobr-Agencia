package com.agenciacafespring.agenciacafej.controller;

import com.agenciacafespring.agenciacafej.controller.request.CategoriaRequest;
import com.agenciacafespring.agenciacafej.controller.response.CategoriaResponse;
import com.agenciacafespring.agenciacafej.entity.Categoria;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.agenciacafespring.agenciacafej.controller.services.service.CatergoriaService;

import java.util.List;


@RestController
@RequestMapping("categoria/v1")
@RequiredArgsConstructor
public class CategoriaRestController {
    private final CatergoriaService categoriaService;

    @GetMapping("/list")
    public ResponseEntity<List<Categoria>> listCategoria() {
        List<Categoria> categoriaList = categoriaService.getListCategoria();
        return new ResponseEntity<>(categoriaList, HttpStatus.ACCEPTED);
    }


    @GetMapping("/delete")
    public ResponseEntity<String> deleteCategoria(@RequestParam(name = "id") Long id ){
        categoriaService.deleteCategoria(id);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<CategoriaResponse>  searchCategoria(@PathVariable Long id){
        CategoriaResponse categoriaResponse =  categoriaService.searchCategoria(id);
        return ResponseEntity.accepted().body(categoriaResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveCategoria(@RequestBody CategoriaRequest categoriaRequest){
        categoriaService.saveCategoria(categoriaRequest);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateCategoria(@RequestBody CategoriaRequest categoriaRequest){
        categoriaService.updateCategoria(categoriaRequest);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }
}

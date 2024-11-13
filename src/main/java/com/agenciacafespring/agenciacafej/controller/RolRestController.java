package com.agenciacafespring.agenciacafej.controller;

import com.agenciacafespring.agenciacafej.controller.request.RolRequest;
import com.agenciacafespring.agenciacafej.controller.response.RolResponse;
import com.agenciacafespring.agenciacafej.controller.services.service.RolService;
import com.agenciacafespring.agenciacafej.entity.Rol;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rol/v1")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class RolRestController {
    private final RolService rolService;
    @GetMapping("/list")
    public ResponseEntity<List<Rol>> listRol() {
        List<Rol> rolList = rolService.getListRol();
        return new ResponseEntity<>(rolList, HttpStatus.ACCEPTED);
    }


    @GetMapping("/delete")
    public ResponseEntity<String> deleteRol(@RequestParam(name = "id") Long id ){
        rolService.deleteRol(id);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<RolResponse>  searchRol(@PathVariable Long id){
        RolResponse rolResponse =  rolService.searchRol(id);
        return ResponseEntity.accepted().body(rolResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveRol(@RequestBody RolRequest rolRequest){
        rolService.saveRol(rolRequest);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateRol(@RequestBody RolRequest rolRequest){
        rolService.updateRol(rolRequest);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }
}

package com.agenciacafespring.agenciacafej.controller;

import com.agenciacafespring.agenciacafej.controller.request.FacturaRequest;
import com.agenciacafespring.agenciacafej.controller.request.PermisoRequest;
import com.agenciacafespring.agenciacafej.controller.response.FacturaResponse;
import com.agenciacafespring.agenciacafej.controller.response.PermisoResponse;
import com.agenciacafespring.agenciacafej.controller.services.service.PermisoService;
import com.agenciacafespring.agenciacafej.entity.Factura;
import com.agenciacafespring.agenciacafej.entity.Permiso;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("permiso/v1")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class PermisoRestController {
    private final PermisoService permisoService;

    @GetMapping("/list")
    public ResponseEntity<List<Permiso>> listPermiso() {
        List<Permiso> permisoList = permisoService.getListPermiso();
        return new ResponseEntity<>(permisoList, HttpStatus.ACCEPTED);
    }


    @GetMapping("/delete")
    public ResponseEntity<String> deletePermiso(@RequestParam(name = "id") Long id ){
        permisoService.deletePermiso(id);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<PermisoResponse>  searchPermiso(@PathVariable Long id){
        PermisoResponse permisoResponse =  permisoService.searchPermiso(id);
        return ResponseEntity.accepted().body(permisoResponse);
    }

    @PostMapping("/save")
    public ResponseEntity<String> savePermiso(@RequestBody PermisoRequest permisoRequest){
        permisoService.savePermiso(permisoRequest);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updatePermiso(@RequestBody PermisoRequest permisoRequest){
        permisoService.updatePermiso(permisoRequest);
        return ResponseEntity.accepted().body("La accion solicitada se realizo");
    }
}

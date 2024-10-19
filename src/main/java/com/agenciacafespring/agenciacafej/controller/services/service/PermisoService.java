package com.agenciacafespring.agenciacafej.controller.services.service;

import com.agenciacafespring.agenciacafej.controller.request.PermisoRequest;
import com.agenciacafespring.agenciacafej.controller.response.PermisoResponse;
import com.agenciacafespring.agenciacafej.entity.Permiso;

import java.util.List;

public interface PermisoService {

    List<Permiso> getListPermiso();
    void deletePermiso(Long id);
    PermisoResponse searchPermiso(Long id);
    void savePermiso(PermisoRequest permisoRequest);
    void updatePermiso(PermisoRequest permisoRequest);
}

package com.agenciacafespring.agenciacafej.controller.services.service;

import com.agenciacafespring.agenciacafej.controller.request.RolRequest;
import com.agenciacafespring.agenciacafej.controller.response.RolResponse;
import com.agenciacafespring.agenciacafej.entity.Rol;

import java.util.List;

public interface RolService {

    List<Rol> getListRol();
    void deleteRol(Long id);
    RolResponse searchRol(Long id);
    void saveRol(RolRequest rolRequest);
    void updateRol(RolRequest rolRequest);
}

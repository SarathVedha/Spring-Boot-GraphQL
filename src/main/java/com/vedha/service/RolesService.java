package com.vedha.service;

import com.vedha.dto.RolesDTO;

import java.util.List;
import java.util.Map;

public interface RolesService {

    List<RolesDTO> getAllRoles();

    RolesDTO saveRole(RolesDTO rolesDTO);

    RolesDTO updateRole(Long roleId, RolesDTO rolesDTO);

    Map<String, String> deleteRole(Long roleId);

    RolesDTO getRoleById(Long id);
}

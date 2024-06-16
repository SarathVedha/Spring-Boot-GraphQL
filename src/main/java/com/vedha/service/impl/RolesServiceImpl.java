package com.vedha.service.impl;

import com.vedha.dto.RolesDTO;
import com.vedha.entity.Roles;
import com.vedha.repository.RolesRepository;
import com.vedha.service.RolesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class RolesServiceImpl implements RolesService {

    private final ModelMapper modelMapper;

    private final RolesRepository rolesRepository;

    @Override
    public List<RolesDTO> getAllRoles() {

        return rolesRepository.findAll().stream().map((element) -> modelMapper.map(element, RolesDTO.class)).toList();
    }

    @Override
    public RolesDTO saveRole(RolesDTO rolesDTO) {

        return modelMapper.map(rolesRepository.save(modelMapper.map(rolesDTO, Roles.class)), RolesDTO.class);
    }

    @Override
    public RolesDTO updateRole(Long roleId, RolesDTO rolesDTO) {

        Roles roles = rolesRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role Not Found: ".concat(String.valueOf(roleId))));
        roles.setName(rolesDTO.getName());
        roles.setDescription(roles.getDescription());

        return modelMapper.map(rolesRepository.save(roles), RolesDTO.class);
    }

    @Override
    public Map<String, String> deleteRole(Long roleId) {

        rolesRepository.deleteById(roleId);
        return Map.of("message", "Role deleted successfully", "status", "success", "id", String.valueOf(roleId));
    }

    @Override
    public RolesDTO getRoleById(Long id) {

        return modelMapper.map(rolesRepository.findById(id).orElseThrow(() -> new RuntimeException("Role Not Found: ".concat(String.valueOf(id)))), RolesDTO.class);
    }
}

package com.vedha.controller;

import com.vedha.dto.RolesDTO;
import com.vedha.dto.UsersDTO;
import com.vedha.service.RolesService;
import com.vedha.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class GraphQLController {

    private final UsersService usersService;

    private final RolesService rolesService;

    @QueryMapping
    public List<UsersDTO> getAllUsers() {

        return usersService.getAllUsers();
    }

    @MutationMapping
    public UsersDTO saveUser(@Argument("user") UsersDTO usersDTO) {

        return usersService.saveUser(usersDTO);
    }

    @MutationMapping
    public UsersDTO updateUser(@Argument("id") Long id, @Argument("user") UsersDTO usersDTO) {

        return usersService.updateUser(id, usersDTO);
    }

    @MutationMapping
    public Map<String, String> deleteUser(@Argument("id") Long id) {

        return usersService.deleteUser(id);
    }

    @QueryMapping
    public UsersDTO getUserById(@Argument("id") Long id) {

        return usersService.getUserById(id);
    }

    @QueryMapping
    public List<RolesDTO> getAllRoles() {

        return rolesService.getAllRoles();
    }

    @MutationMapping
    public RolesDTO saveRole(@Argument("role") RolesDTO rolesDTO) {

        return rolesService.saveRole(rolesDTO);
    }

    @MutationMapping
    public RolesDTO updateRole(@Argument("id") Long id, @Argument("role") RolesDTO rolesDTO) {

        return rolesService.updateRole(id, rolesDTO);
    }
    @MutationMapping
    public Map<String, String> deleteRole(@Argument("id") Long id) {

        return rolesService.deleteRole(id);
    }

    @QueryMapping
    public RolesDTO getRoleById(@Argument("id") Long id) {

        return rolesService.getRoleById(id);
    }
}

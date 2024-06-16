package com.vedha.controller;

import com.vedha.dto.RolesDTO;
import com.vedha.dto.UsersDTO;
import com.vedha.service.RolesService;
import com.vedha.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
@Tag(name = "Users", description = "Users API")
public class RestControllers {

    private final UsersService usersService;

    private final RolesService rolesService;

    @Operation(summary = "Get all users", description = "Get all users")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UsersDTO>> getAllUsers() {

        return ResponseEntity.ok(usersService.getAllUsers());
    }

    @Operation(summary = "Save user", description = "Save user")
    @ApiResponse(responseCode = "201", description = "HTTP Status 201 Created")
    @PostMapping(value = "/saveUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsersDTO> saveUser(@RequestBody UsersDTO usersDTO) {

        return new ResponseEntity<>(usersService.saveUser(usersDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "Update user", description = "Update user")
    @ApiResponse(responseCode = "202", description = "HTTP Status 202 Accepted")
    @PutMapping(value = "/updateUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsersDTO> updateUser(@RequestParam("id") Long id, @RequestBody UsersDTO usersDTO) {

        return ResponseEntity.accepted().body(usersService.updateUser(id, usersDTO));
    }

    @Operation(summary = "Delete user", description = "Delete user")
    @ApiResponse(responseCode = "202", description = "HTTP Status 202 Accepted")
    @PostMapping(value = "/deleteUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> deleteUser(@RequestParam("id") Long id) {

        return ResponseEntity.accepted().body(usersService.deleteUser(id));
    }

    @Operation(summary = "Get user by id", description = "Get user by id")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @GetMapping(value = "/users/id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsersDTO> getUserById(@RequestParam("id") Long id) {

        return ResponseEntity.ok(usersService.getUserById(id));
    }

    @Operation(summary = "Get all roles", description = "Get all roles")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @GetMapping(value = "/roles", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RolesDTO>> getAllRoles() {

        return ResponseEntity.ok(rolesService.getAllRoles());
    }

    @Operation(summary = "Save role", description = "Save role")
    @ApiResponse(responseCode = "201", description = "HTTP Status 201 Created")
    @PostMapping(value = "/saveRole", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RolesDTO> saveRole(@RequestBody RolesDTO rolesDTO) {

        return new ResponseEntity<>(rolesService.saveRole(rolesDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "Update role", description = "Update role")
    @ApiResponse(responseCode = "202", description = "HTTP Status 202 Accepted")
    @PutMapping(value = "/updateRole", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RolesDTO> updateRole(@RequestParam("id") Long id, @RequestBody RolesDTO rolesDTO) {

        return ResponseEntity.accepted().body(rolesService.updateRole(id, rolesDTO));
    }

    @Operation(summary = "Delete role", description = "Delete role")
    @ApiResponse(responseCode = "202", description = "HTTP Status 202 Accepted")
    @PostMapping(value = "/deleteRole", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> deleteRole(@RequestParam("id") Long id) {

        return ResponseEntity.accepted().body(rolesService.deleteRole(id));
    }

    @Operation(summary = "Get role by id", description = "Get role by id")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @GetMapping(value = "/roles/id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RolesDTO> getRoleById(@RequestParam("id") Long id) {

        return ResponseEntity.ok(rolesService.getRoleById(id));
    }

}

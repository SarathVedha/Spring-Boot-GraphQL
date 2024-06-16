package com.vedha.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "UsersDTO", description = "Users Data Transfer Object")
public class UsersDTO {

    @Schema(description = "User ID", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Username", example = "user")
    private String username;

    @Schema(description = "Password", example = "password")
    private String password;

    @Schema(description = "Email", example = "user@gmail.com")
    private String email;

    @Schema(description = "Roles", accessMode = Schema.AccessMode.READ_ONLY)
    private Set<RolesDTO> roles;
}

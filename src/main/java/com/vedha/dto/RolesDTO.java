package com.vedha.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "RolesDTO", description = "Roles Data Transfer Object")
public class RolesDTO {

    @Schema(description = "Role ID", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Role Name", example = "ADMIN")
    private String name;

    @Schema(description = "Role Description", example = "Administrator")
    private String description;
}

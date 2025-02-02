package com.olpasa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectorDto {

    private Integer id_sector;

    @NonNull
    //@NotEmpty
    //@NotBlank
    @Size(min = 3, max = 70, message = "{nombre.size}")
    private String nombre;
    private String codigo_tony;
    private String region;
}

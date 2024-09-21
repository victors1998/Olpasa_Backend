package com.olpasa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectorDto {

    private int idSector;

    @NonNull
    @NotEmpty
    @NotBlank
    private String nombre;
    private String codigoTony;
    private String region;
}

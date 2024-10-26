package com.olpasa.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClasificacionDto {

    private Integer idClas;

    private String descripcion;

    private String Usuario;

}

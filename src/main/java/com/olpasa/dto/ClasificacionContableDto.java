package com.olpasa.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClasificacionContableDto {

    private Integer id_clasificacion;

    private String descripcion;

    private String cuenta_almacen;

    private String cuenta_compra;

    private String cuenta_variacion;
}

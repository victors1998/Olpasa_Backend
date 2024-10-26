package com.olpasa.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClasificacionContableDto {

    private Integer idClasificacionContable;

    private String descripcion;

    private String cuentaAlmacen;

    private String cuentaCompra;

    private String cuentaVariacion;
}

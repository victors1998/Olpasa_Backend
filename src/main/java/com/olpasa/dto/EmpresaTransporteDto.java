package com.olpasa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaTransporteDto {
    private Integer codigo_et;
    private String estado;
    private Integer id_cuenta;
    private String usuario;
}

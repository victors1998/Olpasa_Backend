package com.olpasa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PrivilegioDto {

    private Integer id_privilegio;
    private String descripcion;
    private String Observacion;
    private String Modulo;

}

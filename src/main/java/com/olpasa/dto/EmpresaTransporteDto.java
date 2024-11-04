package com.olpasa.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaTransporteDto {

    @Column(name = "codigo_et")
    private Integer codigo_et;
    private String estado;
    private Integer id_cuenta;
    private String usuario;
}

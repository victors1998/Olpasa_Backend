package com.olpasa.dto;

import com.olpasa.model.EmpresaTransporte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VDTO {

    private Integer id_vehiculo;
    private EmpresaTransporte codigo_et;
    private String tipo;
    private String marca;
    private String estado;
    private String placa;
    private BigDecimal alto;
    private BigDecimal ancho;
    private BigDecimal largo;
    private String constancia;
    private String configuracion_vehicular;
    private Integer peso_max_permitido;
}

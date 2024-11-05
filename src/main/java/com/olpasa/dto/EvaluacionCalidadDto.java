package com.olpasa.dto;


import com.olpasa.model.CriterioCalidad;
import com.olpasa.model.Pesaje;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluacionCalidadDto {

    private Integer id_evaluacion;

    private Pesaje id_pesaje;

    private CriterioCalidad id_criterio;

    private BigDecimal valor;

    private String codigo_um;

    private String castigo;

    private String forma_castigo;

    private String factor_castigo;

    private String usuario;

    private String tam_rac;
}

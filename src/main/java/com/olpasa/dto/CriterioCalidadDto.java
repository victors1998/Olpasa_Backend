package com.olpasa.dto;

import com.olpasa.model.UnidadMedida;
import jakarta.persistence.Column;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CriterioCalidadDto {

    private Integer id_criterio;

    private UnidadMedida codigo_um;

    private String descripcion;

    private String castigo;

    private String forma_castigo;

    private BigDecimal factor_castigo;

    private String factor_variable;

    private String impresion_ticket;

    private String estado;

    private String usuario;
}

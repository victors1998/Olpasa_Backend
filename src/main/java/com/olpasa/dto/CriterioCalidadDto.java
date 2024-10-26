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

    private Integer idCriterio;

    private UnidadMedida codigoUm;

    private String descripcion;

    private String castigo;

    private String formaCastigo;

    private BigDecimal factorCastigo;

    private String factorVariable;

    private String impresionTicket;

    private String estado;

    private String usuario;
}

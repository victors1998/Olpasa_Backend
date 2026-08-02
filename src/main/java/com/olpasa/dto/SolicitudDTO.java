package com.olpasa.dto;

import com.olpasa.model.Concepto;
import com.olpasa.model.Credito;
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
public class SolicitudDTO {

    private Concepto idConcepto;
    private String observacionSolicitud;
    private String elaborado;
    private String aprobado;
    private String serie;
    private String numero;
    private Integer verision;
    private Credito idCredito;
    private BigDecimal tipoCambio;
    private BigDecimal peso;
    private BigDecimal precio;
}

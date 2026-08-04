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

    private Integer idSol;
    private String serie;
    private String numero;
    private String fecha; // usa String si Angular envía texto
    private String solicitante;
    private String estado;
    private BigDecimal montoaprobado;
    private BigDecimal montoSolicitado;
    private String fpagSol;
    private String nombre;
    private String numeroCuenta;
    private String cci;
}

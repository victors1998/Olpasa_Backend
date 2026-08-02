package com.olpasa.dto;

import java.math.BigDecimal;

public interface SDTO {

    Integer getIdSol();
    String getSerie();
    String getNumero();
    String getFecha();
    String getSolicitante();
    String getEstado();
    BigDecimal getMontoSolicitado();
    BigDecimal getMontoaprobado();
    String getFpagSol();
    String getNombCon();
    String getAprobado();
    String getNombre();
    String getNumeroCuenta();
    String getCci();

}

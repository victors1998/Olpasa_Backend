package com.olpasa.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface PMDto {

    int getIdPesoMedida();
    String getFecha();
    String getSerie();
    String getNumero();
    String getCliente();
    String getEmpresaTransporte();
    String getNumRegistro();
    String getEstado();

    // DATOS DE PLACA PRINCIPAL
    String getPlacaPrincipal();
    BigDecimal getLargoPrincipal();
    BigDecimal getAnchoPrincipal();
    BigDecimal getAltoPrincipal();
    String getConfiguracionVehicular();

    // DATOS DE PLACA SECUNDARIO
    String getPlacaSecundario();
    BigDecimal getLargoSecundario();
    BigDecimal getAnchoSecundario();
    BigDecimal getAltoSecundario();

    String getPesoMaxPerm();
    String getPesoBrutoTransp();




}

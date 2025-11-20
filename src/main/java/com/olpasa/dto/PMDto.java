package com.olpasa.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface PMDto {

    int getIdPesoMedida();
    String getFecha();
    String getNumTicket();
    String getSerie();
    String getNumero();
    String getProveedor();
    String getTransportista();
    String getPesoSalida();
    // PLACA PRINCIPAL
    int getIdVehiculoPrincipal();
    String getPlacaPrincipal();
    BigDecimal getAltoPrincipal();
    BigDecimal getAnchoPrincipal();
    BigDecimal getLargoPrincipal();
    String getConfiguracion();
    String getPesoPermitido();
    //PLACA SECUNDARIO
    Long getIdVehiculoSecundario();
    String getPlacaSecundario();
    BigDecimal getAltoSecundario();
    BigDecimal getAnchoSecundario();
    BigDecimal getLargoSecundario();

}

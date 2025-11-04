package com.olpasa.dto;

import java.math.BigDecimal;

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
    String getConfiguracionVehicular();
    String getPesoPermitido();
    //PLACA SECUNDARIO
    int getIdVehiculoSecundario();
    String getPlacaSecundario();
    BigDecimal getAltoSecundario();
    BigDecimal getAnchoSecundario();
    BigDecimal getLargoSecundario();

}

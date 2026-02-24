package com.olpasa.dto;

import java.math.BigDecimal;

public interface GuiaDTO {

    Integer getIdGuia();
    String getFechaEmision();
    String getSerie();
    String getNumero();
    String getDescripcion();
    String getNumDocDestinatario();
    String getUnidadMedida();
    String getTransportista();
    String getConductores();
    String getIdPesaje();
    String getNumTicket();
    Integer getPesoIngreso();
    Integer getPesoSalida();
    Integer getPesoNeto();
    String getCliente();
    Integer getIdVehiculoPrincipal();
    String getPlacaPrincipal();
    BigDecimal getPesoMaxPermitido();
    Integer getIdVehiculoSecundario();
    String getPlacaSecundario();
}

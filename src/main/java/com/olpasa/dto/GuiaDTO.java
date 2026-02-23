package com.olpasa.dto;

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
    Integer getPesoMaxPermitido();
    Integer getIdVehiculoSecundario();
    String getPlacaSecundario();
}

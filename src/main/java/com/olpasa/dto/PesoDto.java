package com.olpasa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PesoDto {

    private int idPesaje;
    private String transportista;
    private String numTicket;
    private String proveedor;
}

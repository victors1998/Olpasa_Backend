package com.olpasa.dto;

import com.olpasa.model.Vehiculo;
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
    private String placa;
    private String proveedor;
}

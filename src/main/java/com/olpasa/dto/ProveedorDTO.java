package com.olpasa.dto;

import com.olpasa.model.CuentaBancaria;
import com.olpasa.model.Sector;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProveedorDTO {

    private Integer codigo;
    private Sector id_sector;
    private CuentaBancaria id_cuenta;
    private String es_mp;
    private String es_suministro;
    private String estado;
    private String anexo_concar;
    private String enviar_sms;
    private String tipo_comp;
    private String usuario;
}

package com.olpasa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {

    private Integer codigo;
    private String tipo;
    private String tipo_documento;
    private String numero_documento;
    private String nombres;
    private String paterno;
    private String materno;
    private String telefono;
    private String direccion;
    private String direccion2;
    private String habilitado;
    private String balanza;
    private String esMp;
    private String es_transportista;
    private String es_bienes;
    private String anexo_concar_clientes;
    private String cuenta;
    private Integer banco;
    private Integer codigo_tony;
    private String relacionado;
    private String cod_ubigeo;
    private String cod_ubigeo2;
}

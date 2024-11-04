package com.olpasa.dto;

import com.olpasa.model.EmpresaTransporte;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConductorDto  {

    private Integer codigo;

    @Column(name = "codigo_et")
    private EmpresaTransporte codigo_et;
    private String licencia;
    private String numero_documento;
    private String categoria;
    private String nombres;
    private String paterno;
    private String materno;
    private String estado;
    private String usuario;
    private String cod_tipo_doc;
}

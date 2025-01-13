package com.olpasa.dto;

import com.olpasa.model.Proveedor;
import com.olpasa.model.Sector;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParcelDto {

    @Column(name = "id_parcela")
    private Integer id_parcela;

    private Sector id_sector;

    private Proveedor codigo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(precision = 18, scale = 2, name = "area" )
    private BigDecimal area;

    @Column(name = "estado")
    private String estado;

    @Column(name = "usuario")
    private String usuario;
}

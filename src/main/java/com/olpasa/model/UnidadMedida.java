package com.olpasa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "unidad_medida")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UnidadMedida {

    @Id
    @Column(name = "codigo_um")
    @EqualsAndHashCode.Include
    private String codigoUm;

    @Column(name = "desccripcion", length = 255)
    private String descripcion;

    @Column(name = "codigo_onu", length = 255)
    private String codigoOnu;

    @Column(name = "codigo_sunat", length = 255)
    private String codigoSunat;
}

package com.olpasa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @EqualsAndHashCode.Exclude
    @Column(name = "codigo_um", length = 10)
    private String codigoUm;

    @Column(name = "descripcion", length = 20, nullable = false)
    private String descripcion;

    @Column(name = "codigo_onu", length = 15, nullable = false)
    private String codigoOnu;

    @Column(name = "codigo_sunat", length = 15, nullable = false)
    private String codigoSunat;
}

package com.olpasa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "unidad_medida")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UnidadMedida {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "codigo_um", length = 10)
    private String codigo_um;

    @Column(name = "descripcion", length = 20, nullable = false)
    private String descripcion;

    @Column(name = "codigo_onu", length = 15, nullable = false)
    private String codigo_onu;

    @Column(name = "codigo_sunat", length = 15, nullable = false)
    private String codigo_sunat;


}

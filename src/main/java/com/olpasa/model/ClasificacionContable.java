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
@Table(name = "clasificacion_contable")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ClasificacionContable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clasificacion")
    @EqualsAndHashCode.Include
    private Integer id_clasificacion;

    @Column(name = "descripcion", length = 100, nullable = false)
    private String descripcion;

    @Column(name = "cuenta_almacen", length = 10, nullable = false)
    private String cuenta_almacen;

    @Column(name = "cuenta_compra", length = 10, nullable = false)
    private String cuenta_compra;

    @Column(name = "cuenta_variacion", length = 10)
    private String cuenta_variacion;

    
}

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
@Table(name = "sector")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TipoOperacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_to")
    @EqualsAndHashCode.Include
    private Integer idTo;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Column(name = "tipo", length = 255)
    private String tipo;

    @Column(name = "estado", length = 255)
    private String estado;
}

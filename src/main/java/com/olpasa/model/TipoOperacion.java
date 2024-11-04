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
@Table(name = "tipo_operacion")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TipoOperacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id_to")
    private Integer id_to;

    @Column(name = "descripcion", length = 250, nullable = false)
    private String descripcion;

    @Column(name = "estado", length = 20)
    private String estado;
}

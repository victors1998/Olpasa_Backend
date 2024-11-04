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
@Table(name = "privilegio")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Privilegio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id_privilegio")
    private Integer id_privilegio;

    @Column(name = "descripcion", length = 50)
    private String descripcion;

    @Column(name = "Observacion", length = 150)
    private String observacion;

    @Column(name = "Modulo", length = 150)
    private String modulo;
}

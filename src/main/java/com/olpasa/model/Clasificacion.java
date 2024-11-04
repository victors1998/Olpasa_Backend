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
@Table(name = "clasificacion")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Clasificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clas")
    @EqualsAndHashCode.Include
    private Integer id_clas;

    @Column(name = "descripcion", length = 150)
    private String descripcion;

    @Column(name = "usuario", length = 50)
    private String Usuario;
}

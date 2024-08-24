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
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // comparacion
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sector")
    @EqualsAndHashCode.Include
    private Integer idSector;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "codigo_tony")
    private Integer codigoTony;

    @Column(name = "region", length = 10)
    private String region;
}

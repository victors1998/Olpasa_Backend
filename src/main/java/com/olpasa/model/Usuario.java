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
@Table(name = "banco")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario {

    @Id
    @EqualsAndHashCode.Exclude
    @Column(name = "nombre_cuenta", length = 50)
    private String nombreCuenta;

    @Column(name = "nombres", length = 50)
    private String nombres;

    @Column(name = "estado", length = 50)
    private String estado;

    @Column(name = "password", length = 250)
    private String password;
}

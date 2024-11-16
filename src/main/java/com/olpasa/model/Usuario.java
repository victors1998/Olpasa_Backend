package com.olpasa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "usuario")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "nombre_cuenta", length = 50)
    private String nombre_cuenta;

    @Column(name = "nombres", length = 50)
    private String nombres;

    @Column(name = "estado", length = 50)
    private String estado;

    @Column(name = "password", length = 250)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_privilegio",
            joinColumns = @JoinColumn(name = "nombre_cuenta", referencedColumnName = "nombre_cuenta"),
            inverseJoinColumns = @JoinColumn(name = "id_privilegio", referencedColumnName = "id_privilegio")
    )
    private List<Privilegio> privilegios;
}

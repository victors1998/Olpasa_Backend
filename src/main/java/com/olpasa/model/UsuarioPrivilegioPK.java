package com.olpasa.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class UsuarioPrivilegioPK {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_up")
    private Integer idUp;

    @ManyToOne
    @JoinColumn(name = "nombre_cuenta")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_privilegio")
    private Privilegio privilegio;
}

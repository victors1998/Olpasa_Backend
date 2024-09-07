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
@IdClass(UsuarioPrivilegioPK.class)
@Table(name = "usuario_privilegio")
public class UsuarioPrivilegio {


    @Id
    @Column(name = "nombre_cuenta")
    private Usuario nombreCuenta;

    @Id
    @Column(name = "id_privilegio")
    private Privilegio idPrivilegio;


}

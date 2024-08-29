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
public class UsuarioPrivilegio {


    @Id
    private Usuario nombreUsuario;

    @Id
    private Privilegio idPrivilegio;
}

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
@Table(name = "usuario_privilegio")
public class UsuarioPrivilegio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_up")
    private Integer id_up;

    @ManyToOne
    @JoinColumn(name = "nombre_cuenta", nullable = false, foreignKey = @ForeignKey(name = "FK_usuario_privilegio_usuario"))
    private Usuario nombre_cuenta;

    @ManyToOne
    @JoinColumn(name = "id_privilegio", nullable = false, foreignKey = @ForeignKey(name = "FK_usuario_privilegio_privilegio"))
    private Privilegio id_privilegio;


}

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
@Table(name = "cuenta_bancaria")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CuentaBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id_cuenta")
    private Integer idCuenta;

    @ManyToOne
    @JoinColumn(name = "codigo", nullable = false, foreignKey = @ForeignKey(name = "persona_cuenta_bancaria_fk"))
    private Persona codigo;

    @ManyToOne
    @JoinColumn(name = "id_banco", nullable = false, foreignKey = @ForeignKey(name = "bancos_cuenta_bancaria_fk"))
    private Banco idBanco;

    @Column(name = "numero", length = 30)
    private String numero;

    @Column(name = "estado", length = 10)
    private String estado;

    @Column(name = "cci", length = 50)
    private String cci;

    @Column(name = "usuario", length = 50)
    private String usuario;

    @Column(name = "Observacion ")
    private String Observacion;
}

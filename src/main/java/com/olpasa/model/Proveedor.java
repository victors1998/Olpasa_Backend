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
@Table(name = "proveedor")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    @Column(name = "codigo")
    private Integer codigo;

    @ManyToOne
    @JoinColumn(name = "id_sector", nullable = false, foreignKey = @ForeignKey(name = "sector_proveedor_fk"))
    private Sector idSector;

    @ManyToOne
    @JoinColumn(name = "id_cuenta", nullable = false, foreignKey = @ForeignKey(name = "cuenta_bancaria_proveedor_fk"))
    private CuentaBancaria idCuenta;

    @Column(name = "es_mp")
    private String esMp;

    @Column(name = "es_suministro")
    private String esSuministro;

    @Column(name = "estado")
    private String estado;

    @Column(name = "anexoconcar")
    private String anexoConcar;

    @Column(name = "enviar_sms")
    private String enviarSms;

    @Column(name = "tipo_comp")
    private String tipoComp;

    @Column(name = "usuario")
    private String usuario;
}

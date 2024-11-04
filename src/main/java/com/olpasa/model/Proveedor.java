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
    @EqualsAndHashCode.Include
    @Column(name = "codigo")
    private Integer codigo;

    @ManyToOne
    @JoinColumn(name = "id_sector", nullable = false, foreignKey = @ForeignKey(name = "sector_proveedor_fk"))
    private Sector id_sector;

    @ManyToOne
    @JoinColumn(name = "id_cuenta", nullable = false, foreignKey = @ForeignKey(name = "cuenta_bancaria_proveedor_fk"))
    private CuentaBancaria id_cuenta;

    @Column(name = "es_mp")
    private String es_mp;

    @Column(name = "es_suministro")
    private String es_suministro;

    @Column(name = "estado")
    private String estado;

    @Column(name = "anexoconcar")
    private String anexo_concar;

    @Column(name = "enviar_sms")
    private String enviar_sms;

    @Column(name = "tipo_comp")
    private String tipo_comp;

    @Column(name = "usuario")
    private String usuario;
}

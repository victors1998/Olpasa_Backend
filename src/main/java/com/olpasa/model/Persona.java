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
@Table(name = "persona")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "tipo", length = 255)
    private String tipo;

    @Column(name = "tipo_documento", length = 255)
    private String tipoDocumento;

    @Column(name = "nombres", length = 255)
    private String nombres;

    @Column(name = "paterno", length = 255)
    private String paterno;

    @Column(name = "materno", length = 255)
    private String materno;

    @Column(name = "telefono", length = 255)
    private String telefono;

    @Column(name = "direccion", length = 255)
    private String direccion;

    @Column(name = "direccion2", length = 255)
    private String direccion2;

    @Column(name = "habilitado", length = 255)
    private String habilitado;

    @Column(name = "balanza", length = 255)
    private String balanza;

    @Column(name = "es_mp", length = 255)
    private String esMp;

    @Column(name = "es_transportista", length = 255)
    private String esTransportista;

    @Column(name = "es_bienes", length = 255)
    private String esBienes;

    @Column(name = "cuenta", length = 255)
    private String cuenta;

    @Column(name = "banco", length = 255)
    private String banco;

    @Column(name = "codigo_tony", length = 255)
    private String codigoTony;

}

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
    @EqualsAndHashCode.Include
    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "tipo", length = 20)
    private String tipo;

    @Column(name = "tipo_documento", length = 20)
    private String tipoDocumento;

    @Column(name = "numero_documento", length = 15)
    private String numeroDocumento;

    @Column(name = "nombres", length = 150)
    private String nombres;

    @Column(name = "paterno", length = 50)
    private String paterno;

    @Column(name = "materno", length = 50)
    private String materno;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "direccion", length = 250)
    private String direccion;

    @Column(name = "direccion2", length = 250)
    private String direccion2;

    @Column(name = "habilitado", length = 5)
    private String habilitado;

    @Column(name = "balanza", length = 5)
    private String balanza;

    @Column(name = "es_mp", length = 5)
    private String esMp;

    @Column(name = "es_transportista", length = 5)
    private String esTransportista;

    @Column(name = "es_bienes", length = 5)
    private String esBienes;

    @Column(name = "anexo_concar_clientes", length = 20)
    private String anexoConcarClientes;

    @Column(name = "cuenta", length = 20)
    private String cuenta;

    @Column(name = "banco")
    private Integer banco;

    @Column(name = "codigo_tony")
    private Integer codigoTony;

    @Column(name = "relacionado", length = 5)
    private String relacionado;

    @Column(name = "cod_ubigeo", length = 10)
    private String codUbigeo;

    @Column(name = "cod_ubigeo2", length = 10)
    private String codUbigeo2;
}

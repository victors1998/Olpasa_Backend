package com.olpasa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "guia_remision")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class GuiaRemision {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_guia")
    private Integer id_guia;

    @Column(name = "fecha_emision")
    private LocalDate fecha_emision;

    @Column(name = "serie")
    private String serie;

    @Column(name = "numero")
    private String numero;

    @Column(name = "fecha_inicio")
    private LocalDate fecha_inicio;

    @Column(name = "partida")
    private String partida;

    @Column(name = "destino")
    private String destino;

    @Column(name = "motivo_traslado")
    private String motivo_traslado;

    @Column(name = "estado")
    private String estado;

    @Column(name = "observacion")
    private String observacion;

    @ManyToOne
    @JoinColumn(name = "codigo_destinatario", foreignKey = @ForeignKey(name = "persona_guia_remision_fk"))
    private Persona codigo_destinatario;

    @Column(name = "num_doc_dstinatario")
    private String num_doc_dstinatario;

    @Column(name = "version")
    private Integer version;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "presintos")
    private String presintos;

    @ManyToOne
    @JoinColumn(name = "codigo_et", foreignKey = @ForeignKey(name = "FK_guia_remision_empresa_transporte"))
    private EmpresaTransporte codigo_et;

    @ManyToOne
    @JoinColumn(name = "codigo_cond", foreignKey = @ForeignKey(name = "FK_guia_remision_conductor"))
    private EmpresaTransporte codigo_cond;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo", foreignKey = @ForeignKey(name = "FK_guia_remision_vehiculo"))
    private Vehiculo id_vehiculo;

    @Column(name = "pedido")
    private String pedido;

    @Column(name = "user_anulacion")
    private String user_anulacion;

    @Column(name = "fecha_anulacion")
    private LocalDate fecha_anulacion;

    @Column(columnDefinition = "DECIMAL(18,2)", name = "peso_bruto")
    private BigDecimal peso_bruto;

    @Column(name = "um_peso_bruto")
    private String um_peso_bruto;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo2", foreignKey = @ForeignKey(name = "FK_guia_remision_vehiculo2"))
    private Vehiculo id_vehiculo2;

    @Column(name = "codigo_ubigeo_partida")
    private String codigo_ubigeo_partida;

    @Column(name = "codigo_ubigeo_llegada")
    private String codigo_ubigeo_llegada;

    @Column(name = "tipo_transporte")
    private String tipo_transporte;

    @Column(name = "estado_sunat")
    private String estado_sunat;

    @Column(name = "url_sunat", columnDefinition = "varchar(max)", nullable = true)
    private String url_sunat;

    @Column(name = "facturado")
    private String facturado;

}

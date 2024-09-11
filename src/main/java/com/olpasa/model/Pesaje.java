package com.olpasa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "pesaje")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pesaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id_pesaje")
    private Integer idPesaje;

    @Column(name = "num_ticket")
    private String num_ticket;

    @Column(name = "tipo_operacion")
    private String tipo_operacion;

    @ManyToOne
    @JoinColumn(name = "id_to", foreignKey = @ForeignKey(name = "fk_pesaje_operacion"))
    private TipoOperacion idTo;

    @ManyToOne
    @JoinColumn(name = "codigo", nullable = false, foreignKey = @ForeignKey(name = "fk_pesaje_persona"))
    private Persona codigo;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "peso_ingreso")
    private Integer pesoIngreso;

    @Column(name = "peso_salida")
    private Integer pesoSalida;

    @Column(name = "peso_neto")
    private Integer pesoNeto;

    @Column(columnDefinition = "DECIMAL(18,2)", name = "castigo_importe")
    private BigDecimal castigoImporte;

    @Column(name = "castigo_peso")
    private Integer pesoPeso;

    @Column(columnDefinition = "DECIMAL(18,2)", name = "castigo_planilla")
    private BigDecimal castigoPlanilla;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo", nullable = false, foreignKey = @ForeignKey(name = "fk_pesaje_vehiculo"))
    private Vehiculo idVehiculo;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id_vehiculo", foreignKey = @ForeignKey(name = "fk_pesaje_vehiculo2"))
    private Vehiculo vehiculoIdVehiculo;

    @ManyToOne
    @JoinColumn(name = "codigo_et", foreignKey = @ForeignKey(name = "fk_pesaje_empresa_transporte"))
    private EmpresaTransporte codigoEt;

    @ManyToOne
    @JoinColumn(name = "conductor", foreignKey = @ForeignKey(name = "FK_pesaje_conductor"))
    private Conductor conductor;

    @ManyToOne
    @JoinColumn(name = "id_parcela", nullable = false, foreignKey = @ForeignKey(name = "fk_pesaje_parcela"))
    private Parcela idParcela;

    @ManyToOne
    @JoinColumn(name = "cod_producto",foreignKey = @ForeignKey(name = "producto_pesaje_fk"))
    private Producto codProducto;

    @Column(name = "estado")
    private String estado;

    @Column(name = "retencion_flete")
    private String retencionFlete;

    @Column(name = "monto_flete")
    private String montoFlete;

    @Column(name = "tipo_registro")
    private String tipoRegistro;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "version")
    private Integer version;

    @Column(name = "id_liquidacion")
    private Integer idLiquidacion;

    @Column(name = "usuario_ingreso")
    private String usuarioIngreso;

    @Column(name = "usuario_salida")
    private String usuarioSalida;

    @Column(name = "usuario_version")
    private String usuarioVersion;


    @Column(name = "fecha_salida", columnDefinition = "DATETIME2")
    private LocalDateTime fechaSalida;

    @Column(name = "fecha_anul")
    private LocalDateTime fechaAnul;

    @Column(name = "bitacora")
    private String bitacora;

    @Column(name = "estado_sinc")
    private String estadoSinc;

    @Column(name = "reg_guia")
    private String regGuia;

    @Column(name = "serie")
    private String serie;

    @Column(name = "numero")
    private String numero;
}

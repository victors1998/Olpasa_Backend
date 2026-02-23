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

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pesaje")
    private Integer id_pesaje;

    @Column(name = "num_ticket")
    private String num_ticket;

    @Column(name = "tipo_operacion")
    private String tipo_operacion;

    @ManyToOne
    @JoinColumn(name = "id_to", foreignKey = @ForeignKey(name = "fk_pesaje_operacion"))
    private TipoOperacion id_to;

    @ManyToOne
    @JoinColumn(name = "codigo", foreignKey = @ForeignKey(name = "fk_pesaje_persona"))
    private Persona codigo;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "peso_ingreso")
    private Integer peso_ingreso;

    @Column(name = "peso_salida")
    private Integer peso_salida;

    @Column(name = "peso_neto")
    private Integer peso_neto;

    @Column(columnDefinition = "DECIMAL(18,2)", name = "castigo_importe")
    private BigDecimal castigo_importe;

    @Column(name = "castigo_peso")
    private Integer castigo_peso;

    @Column(columnDefinition = "DECIMAL(18,2)", name = "castigo_planilla")
    private BigDecimal castigo_planilla;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo", foreignKey = @ForeignKey(name = "fk_pesaje_vehiculo"))
    private Vehiculo id_vehiculo;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id_vehiculo", foreignKey = @ForeignKey(name = "fk_pesaje_vehiculo2"))
    private Vehiculo vehiculo_id_vehiculo;

    @ManyToOne
    @JoinColumn(name = "codigo_et", foreignKey = @ForeignKey(name = "fk_pesaje_empresa_transporte"))
    private EmpresaTransporte codigo_et;

    @ManyToOne
    @JoinColumn(name = "conductor", foreignKey = @ForeignKey(name = "FK_pesaje_conductor"))
    private Conductor conductor;

    @ManyToOne
    @JoinColumn(name = "id_parcela", nullable = true, foreignKey = @ForeignKey(name = "parcela_pesaje_fk"))
    private Parcela id_parcela;

    @ManyToOne
    @JoinColumn(name = "cod_producto", nullable = true, foreignKey = @ForeignKey(name = "producto_pesaje_fk"))
    private Producto cod_producto;

    @Column(name = "estado")
    private String estado;

    @Column(name = "retencion_flete")
    private String retencion_flete;

    @Column(name = "monto_flete")
    private String monto_flete;

    @Column(name = "tipo_registro")
    private String tipo_registro;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "version")
    private Integer version;

    @Column(name = "id_liquidacion")
    private Integer id_liquidacion;

    @Column(name = "usuario_ingreso")
    private String usuario_ingreso;

    @Column(name = "usuario_salida")
    private String usuario_salida;

    @Column(name = "usuario_version")
    private String usuario_version;


    @Column(name = "fecha_salida")
    private LocalDateTime fecha_salida;

    @Column(name = "fecha_anul")
    private LocalDateTime fecha_anul;

    @Column(name = "bitacora")
    private String bitacora;

    @Column(name = "estado_sinc")
    private String estado_sinc;

    @Column(name = "reg_guia")
    private String reg_guia;

    @Column(name = "serie")
    private String serie;

    @Column(name = "numero")
    private String numero;
}

package com.olpasa.dto;

import com.olpasa.model.*;
import jakarta.persistence.Column;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PesajeDto {

    private Integer id_pesaje;

    @Column(name = "num_ticket")
    private String num_ticket;

    @Column(name = "tipo_operacion")
    private String tipo_operacion;

    private TipoOperacion id_to;

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

    private Vehiculo id_vehiculo;

    private Vehiculo vehiculo_id_vehiculo;

    private EmpresaTransporte codigo_et;


    private Conductor conductor;


    private Parcela id_parcela;


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


    @Column(name = "fecha_salida", columnDefinition = "DATETIME2")
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

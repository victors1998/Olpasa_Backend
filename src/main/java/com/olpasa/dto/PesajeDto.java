package com.olpasa.dto;

import com.olpasa.model.*;
import jakarta.persistence.Column;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @Column(name = "num_ticket")
    private String num_ticket;

    @NotNull
    @Column(name = "tipo_operacion")
    private String tipo_operacion;

    @NotNull
    private TipoOperacion id_to;

    @NotNull
    private Persona codigo;

    @NotNull
    @Column(name = "fecha")
    private LocalDate fecha;

    @NotNull
    @Column(name = "peso_ingreso")
    private Integer peso_ingreso;

    @NotNull
    @Column(name = "peso_salida")
    private Integer peso_salida;

    @NotNull
    @Column(name = "peso_neto")
    private Integer peso_neto;

    @NotNull
    @Column(columnDefinition = "DECIMAL(18,2)", name = "castigo_importe")
    private BigDecimal castigo_importe;

    @NotNull
    @Column(name = "castigo_peso")
    private Integer castigo_peso;

    @NotNull
    @Column(columnDefinition = "DECIMAL(18,2)", name = "castigo_planilla")
    private BigDecimal castigo_planilla;

    @NotNull
    private Vehiculo id_vehiculo;

    @NotNull
    private Vehiculo vehiculo_id_vehiculo;

    @NotNull
    private EmpresaTransporte codigo_et;

    @NotNull
    private Conductor conductor;

    @NotNull
    private Parcela id_parcela;

    @NotNull
    private Producto cod_producto;

    @NotNull
    @Column(name = "estado")
    private String estado;

    @NotNull
    @Column(name = "retencion_flete")
    private String retencion_flete;

    @NotNull
    @Column(name = "monto_flete")
    private String monto_flete;

    @NotNull
    @Column(name = "tipo_registro")
    private String tipo_registro;

    @NotNull
    @Column(name = "observaciones")
    private String observaciones;

    @NotNull
    @Column(name = "version")
    private Integer version;

    @NotNull
    @Column(name = "id_liquidacion")
    private Integer id_liquidacion;

    @NotNull
    @Column(name = "usuario_ingreso")
    private String usuario_ingreso;

    @NotNull
    @Column(name = "usuario_salida")
    private String usuario_salida;

    @NotNull
    @Column(name = "usuario_version")
    private String usuario_version;

    @NotNull
    @Column(name = "fecha_salida", columnDefinition = "DATETIME2")
    private LocalDateTime fecha_salida;

    @NotNull
    @Column(name = "fecha_anul")
    private LocalDateTime fecha_anul;

    @NotNull
    @Column(name = "bitacora")
    private String bitacora;

    @NotNull
    @Column(name = "estado_sinc")
    private String estado_sinc;

    @NotNull
    @Column(name = "reg_guia")
    private String reg_guia;

    @NotNull
    @Column(name = "serie")
    private String serie;

    @NotNull
    @Column(name = "numero")
    private String numero;
}

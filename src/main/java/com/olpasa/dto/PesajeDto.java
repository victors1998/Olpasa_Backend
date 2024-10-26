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

    private Integer idPesaje;

    private String num_ticket;

    private String tipo_operacion;

    private TipoOperacion idTo;

    private Persona codigo;

    private LocalDate fecha;

    private Integer pesoIngreso;

    private Integer pesoSalida;

    private Integer pesoNeto;

    private BigDecimal castigoImporte;

    private Integer pesoPeso;

    private BigDecimal castigoPlanilla;

    private Vehiculo idVehiculo;

    private Vehiculo vehiculoIdVehiculo;

    private EmpresaTransporte codigoEt;

    private Conductor conductor;

    private Parcela idParcela;

    private Producto codProducto;

    private String estado;

    private String retencionFlete;

    private String montoFlete;

    private String tipoRegistro;

    private String observaciones;

    private Integer version;

    private Integer idLiquidacion;

    private String usuarioIngreso;

    private String usuarioSalida;

    private String usuarioVersion;

    private LocalDateTime fechaSalida;

    private LocalDateTime fechaAnul;

    private String bitacora;

    private String estadoSinc;

    private String regGuia;

    private String serie;

    private String numero;
}

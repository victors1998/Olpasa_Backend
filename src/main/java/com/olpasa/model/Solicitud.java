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
@Table(name = "solicitud")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sol")
    @EqualsAndHashCode.Include
    private Integer idSolicitud;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(columnDefinition = "DECIMAL(18,2)", name = "montoaprobado")
    private BigDecimal montoAprobado;

    @Column(columnDefinition = "DECIMAL(18,2)", name = "monto_solicitado")
    private BigDecimal montoSolicitado;

    @Column(name = "estado", length = 20)
    private String estado;

    @Column(columnDefinition = "DECIMAL(18,2)", name = "tasa")
    private BigDecimal tasa;

    @Column(name = "fpag_sol", length = 20)
    private String formaPagoSolicitud;

    @Column(name = "peri_sol", length = 20)
    private Integer periodoSolicitud;

    @Column(name = "periocidad", length = 50)
    private String periocidad;

    @Column(name = "primer_vcmto")
    private LocalDate primerVencimiento;

    @Column(name = "idproveedor")
    private Integer idProveedor;

    @ManyToOne
    @JoinColumn(name = "id_con", foreignKey = @ForeignKey(name = "FK_solicitud_concepto"))
    private Concepto idConcepto;

    @Column(name = "obse_sol", columnDefinition = "TEXT")
    private String observacionSolicitud;

    @Column(name = "elaborado", length = 200)
    private String elaborado;

    @Column(name = "aprobado", length = 200)
    private String aprobado;

    @Column(name = "serie", length = 4)
    private String serie;

    @Column(name = "numero", length = 6)
    private String numero;

    @Column(name = "version")
    private Integer verision;

    @ManyToOne
    @JoinColumn(name = "id_cre", foreignKey = @ForeignKey(name = "FK_solicitud_solicitud"))
    private Credito idCredito;

    @Column(name = "tipo_cambio", precision = 18, scale = 3, nullable = true)
    private BigDecimal tipoCambio;

    @Column(name = "peso", precision = 18, scale = 3, nullable = true)
    private BigDecimal peso;

    @Column(name = "precio", precision = 18, scale = 3, nullable = true)
    private BigDecimal precio;
}

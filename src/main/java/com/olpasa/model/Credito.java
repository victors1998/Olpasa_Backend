package com.olpasa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "credito")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Credito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cre")
    @EqualsAndHashCode.Include
    private Integer idCredito;

    @Column(precision = 10, scale = 2, name = "mont_cre")
    private BigDecimal montoCredito;

    @Column(name = "esta_cre", length = 10)
    private String estadoCredito;

    @Column(name = "fech_cre")
    private LocalDate fechaCredito;

    @Column(precision = 10, scale = 4, name = "inte_cre")
    private BigDecimal interesCredito;

    @Column(precision = 10, scale = 2, name = "impo_cre")
    private BigDecimal importeCredito;

    @ManyToOne
    @JoinColumn(name = "id_con", foreignKey = @ForeignKey(name = "concepto_credito_fk"))
    private Concepto idConcepto;

    @Column(name = "fpag_cre", length = 20)
    private String formaPagoCredito;

    @Column(name = "peri_cre")
    private Integer periodoCredito;

    @Column(name = "id_per")
    private Integer idPeriodo;

    @Column(name = "obse_cre", columnDefinition = "TEXT")
    private String observacionCredito;

    @Column(name = "che_cre", length = 50)
    private String chequeCredito;

    @ManyToOne
    @JoinColumn(name = "codigo", foreignKey = @ForeignKey(name = "FK_credito_perosna"))
    private Persona codigo;

    @Column(name = "reci_cre", length = 50)
    private String reciboCredito;

    @Column(name = "tipo_doc", length = 50)
    private String tipoDocumento;

    @Column(name = "usuario", length = 150)
    private String usuario;

    @Column(name = "version")
    private Integer version;

    @Column(name = "cancelacion")
    private LocalDate cancelacion;

    @Column(name = "f_anulado", columnDefinition = "datetime2(7)")
    private LocalDateTime fechaAnulado;

    @Column(name = "creacion", columnDefinition = "datetimeoffset(7)", nullable = true)
    private OffsetDateTime creacion;

    @Column(name = "estado_sinc", columnDefinition = "char(1)", nullable = true)
    private String estadoSinc;
}

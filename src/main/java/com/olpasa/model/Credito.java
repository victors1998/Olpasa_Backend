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


}

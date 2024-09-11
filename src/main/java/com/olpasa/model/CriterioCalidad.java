package com.olpasa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "criterio_calidad")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CriterioCalidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id_criterio")
    private Integer idCriterio;

    @ManyToOne
    @JoinColumn(name = "codigo_um", nullable = false, foreignKey = @ForeignKey(name = "unidad_medida_criterio_calidad_fk"))
    private UnidadMedida codigoUm;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "castigo")
    private String castigo;

    @Column(name = "forma_castigo")
    private String formaCastigo;

    @Column(columnDefinition = "DECIMAL(18,2)", name = "factor_castigo")
    private BigDecimal factorCastigo;

    @Column(name = "factor_variable")
    private String factorVariable;

    @Column(name = "impresion_ticket")
    private String impresionTicket;

    @Column(name = "estado")
    private String estado;

    @Column(name = "usuario")
    private String usuario;
}

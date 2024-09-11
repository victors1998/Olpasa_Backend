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
@Table(name = "evaluacion_calidad")
public class EvaluacionCalidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id_evaluacion")
    private Integer idEvaluacion;

    @ManyToOne
    @JoinColumn(name = "id_pesaje", nullable = false, foreignKey = @ForeignKey(name = "fk_evaluacionCalidad_pesaje"))
    private Pesaje idPesaje;

    @ManyToOne
    @JoinColumn(name = "id_criterio", nullable = false, foreignKey = @ForeignKey(name = "fk_evaluacionCalidad_criterioCalidad"))
    private CriterioCalidad idCriterio;

    @Column(columnDefinition = "DECIMAL(18,2)", name = "valor")
    private BigDecimal valor;

    @Column(name = "codigo_um")
    private String codigo_um;

    @Column(name = "castigo")
    private String castigo;

    @Column(name = "forma_castigo")
    private String forma_castigo;

    @Column(name = "factor_castigo")
    private String factor_castigo;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "tam_rac")
    private String tam_rac;
}

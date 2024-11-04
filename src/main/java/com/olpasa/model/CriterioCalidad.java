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
    private Integer id_criterio;

    @ManyToOne
    @JoinColumn(name = "codigo_um", nullable = false, foreignKey = @ForeignKey(name = "unidad_medida_criterio_calidad_fk"))
    private UnidadMedida codigo_um;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "castigo")
    private String castigo;

    @Column(name = "forma_castigo")
    private String forma_castigo;

    @Column(columnDefinition = "DECIMAL(18,2)", name = "factor_castigo")
    private BigDecimal factor_castigo;

    @Column(name = "factor_variable")
    private String factor_variable;

    @Column(name = "impresion_ticket")
    private String impresion_ticket;

    @Column(name = "estado")
    private String estado;

    @Column(name = "usuario")
    private String usuario;
}

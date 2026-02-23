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
@Table(name = "peso_medida")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PesoMedida {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_peso_medida")
    private Integer id_peso_medida;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "id_pesaje", nullable = true, foreignKey = @ForeignKey(name = "peso_medida_pesaje_fk"))
    private Pesaje id_pesaje;

    @ManyToOne
    @JoinColumn(name = "id_guia", nullable = true, foreignKey = @ForeignKey(name = "peso_medida_guia_remision_fk"))
    private GuiaRemision id_guia;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo", foreignKey = @ForeignKey(name = "fk_pesomedida_vehiculo"))
    private Vehiculo id_vehiculo;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo2", foreignKey = @ForeignKey(name = "fk_pesomedida_vehiculo2"))
    private Vehiculo id_vehiculo2;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "usuario", nullable = false)
    private String usuario;

    @Column(name = "peso_max_perm", columnDefinition = "DECIMAL(18,3)")
    private BigDecimal peso_max_perm;

    @Column(name = "peso_bruto_transp", columnDefinition = "DECIMAL(18,3)")
    private BigDecimal peso_bruto_transp;

    @Column(name = "num_registro")
    private String num_registro;
}

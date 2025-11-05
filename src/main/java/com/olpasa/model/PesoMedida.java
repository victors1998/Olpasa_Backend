package com.olpasa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "usuario", nullable = false)
    private String usuario;
}

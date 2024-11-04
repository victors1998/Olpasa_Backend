package com.olpasa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "control_rff")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ControlRff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id_control")
    private Integer id_control;

    @ManyToOne
    @JoinColumn(name = "id_pesaje", foreignKey = @ForeignKey(name = "id_pesaje_control"))
    private Pesaje id_pesaje;

    @Column(name = "campaña")
    private String campaña;

    @Column(name = "tipo_racimo")
    private String tipo_racimo;

    @Column(name = "condicion")
    private String condicion;

    @Column(name = "usuario")
    private String usuario;


}

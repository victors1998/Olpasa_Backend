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
@Table(name = "guia_remision")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DetalleGuia {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_guia")
    private Integer id_detalle_guia;

    @ManyToOne
    @JoinColumn(name = "id_guia", foreignKey = @ForeignKey(name = "guia_remision_detalle_guia_fk"))
    private GuiaRemision id_guia;

    @ManyToOne
    @JoinColumn(name = "cod_producto", foreignKey = @ForeignKey(name = "producto_detalle_guia_fk"))
    private Producto cod_producto;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_pesaje", foreignKey = @ForeignKey(name = "pesaje_detalle_guia_fk"))
    private Pesaje id_pesaje;

    @Column(name = "cantidad", precision = 18, scale = 3, nullable = false)
    private BigDecimal cantidad;

    @Column(name = "peso", precision = 18, scale = 3, nullable = false)
    private BigDecimal peso;

    @Column(name = "unidad_medida")
    private String unidad_medida;


}

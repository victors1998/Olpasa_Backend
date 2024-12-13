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
@Table(name = "producto")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "cod_producto")
    private Integer cod_producto;

    @Column(name = "descripcion", length = 150)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "codigo_um", foreignKey = @ForeignKey(name = "unidad_medida_producto_fk"))
    private UnidadMedida codigo_um;

    @Column(name = "precio_venta", columnDefinition = "DECIMAL(18,2)")
    private BigDecimal precio_venta;

    @Column(name = "balanza", length = 5)
    private String balanza;

    @Column(name = "tipo", length = 20)
    private String tipo;

    @Column(name = "numero", length = 50)
    private String usuario;

    @Column(columnDefinition = "DECIMAL(18,3)", name = "stock")
    private BigDecimal stock;

    @Column(columnDefinition = "DECIMAL(18,3)", name = "stock_minimo")
    private BigDecimal stock_minimo;

    @Column(name = "ubicacion", length = 50)
    private String ubicacion;

    @Column(name = "version")
    private Integer version;

    @ManyToOne
    @JoinColumn(name = "id_clasificacion", foreignKey = @ForeignKey(name = "FK_producto_clasificacion_contable"))
    private ClasificacionContable id_clasificacion;

    @ManyToOne
    @JoinColumn(name = "id_clas", nullable = false, foreignKey = @ForeignKey(name = "FK_producto_clasificacion"))
    private Clasificacion id_clas;

    @Column(name = "cuenta_venta_gravada", length = 8)
    private String cuenta_venta_gravada;

    @Column(name = "cuenta_venta_exonerada", length = 8)
    private String cuenta_venta_exonerada;
}

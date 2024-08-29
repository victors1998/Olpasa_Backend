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
@Table(name = "vehiculo")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    @Column(name = "id_vehiculo")
    private Integer idVehiculo;


    @ManyToOne
    @JoinColumn(name = "codigo_et", nullable = false, foreignKey = @ForeignKey(name = "empresa_transporte_vehiculo_fk"))
    private EmpresaTransporte codigoEt;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "marca")
    private String marca;

    @Column(name = "estado")
    private String estado;

    @Column(name = "placa")
    private String placa;

    @Column(columnDefinition = "DECIMAL(18,2)", name = "alto")
    private BigDecimal alto;

    @Column(columnDefinition = "DECIMAL(18,2)", name = "ancho")
    private BigDecimal ancho;

    @Column(columnDefinition = "DECIMAL(18,2)", name = "largo")
    private BigDecimal largo;

    @Column(name = "constancia")
    private String constancia;
}

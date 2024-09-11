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
@Table(name = "parcela")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Parcela {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id_parcela")
    private Integer idParcela;

    @ManyToOne
    @JoinColumn(name = "id_sector", nullable = false, foreignKey = @ForeignKey(name = "fk_parcela_sector"))
    private Sector idSector;

    @ManyToOne
    @JoinColumn(name = "codigo", nullable = false, foreignKey = @ForeignKey(name = "fk_parcela_proveedor"))
    private Proveedor codigo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(precision = 18, scale = 2, name = "area" )
    private BigDecimal area;

    @Column(name = "estado")
    private String estado;

    @Column(name = "usuario")
    private String usuario;
}

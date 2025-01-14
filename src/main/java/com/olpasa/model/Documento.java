package com.olpasa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "documento")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id_documento")
    private Integer id_documento;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_vencimineto")
    private LocalDateTime fecha_vencimineto;

    @Column(name = "url")
    private String url;

    @ManyToOne
    @JoinColumn(name = "codigo", nullable = true, foreignKey = @ForeignKey(name = "proveedor_documento_fk"))
    private Proveedor codigo;

    @ManyToOne
    @JoinColumn(name = "codigo_et", nullable = true, foreignKey = @ForeignKey(name = "empresatransporte_documento_fk"))
    private EmpresaTransporte codigo_et;

    @Column(name = "observacion")
    private String observacion;

}

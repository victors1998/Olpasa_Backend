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
@Table(name = "conductor")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Conductor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "codigo")
    private Integer codigo;

    @ManyToOne
    @JoinColumn(name = "codigo_et", nullable = false, foreignKey = @ForeignKey(name = "empresa_transporte_conductor_fk"))
    private EmpresaTransporte codigoEt;

    @Column(name = "licencia", length = 20)
    private String licencia;

    @Column(name = "numero_documento", length = 11)
    private String numeroDocumento;

    @Column(name = "categoria", length = 10)
    private String categoria;

    @Column(name = "nombres", length = 50)
    private String nombres;

    @Column(name = "paterno", length = 50)
    private String paterno;

    @Column(name = "materno", length = 50)
    private String materno;

    @Column(name = "estado", length = 20)
    private String estado;

    @Column(name = "usuario", length = 50)
    private String usuario;

    @Column(name = "cod_tipo_doc", length = 4)
    private String codTipoDoc;

}

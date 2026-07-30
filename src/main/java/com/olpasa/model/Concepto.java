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
@Table(name = "concepto")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Concepto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_con")
    @EqualsAndHashCode.Include
    private Integer idConcepto;

    @Column(name = "nom_con", length = 20)
    private String nombreConcepto;

    @Column(name = "pri_con")
    private Integer priCon;

    @Column(name = "tipo_con", length = 20)
    private String tipoConcepto;

    @Column(name = "relacionado", length = 50)
    private String relacionado;

    @Column(name = "cuenta", length = 50)
    private String cuenta;

    @Column(name = "usuario", length = 10)
    private String usuario;
}

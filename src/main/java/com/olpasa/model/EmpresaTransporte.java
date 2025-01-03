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
@Table(name = "empresa_transporte")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EmpresaTransporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "codigo_et")
    private Integer codigo_et;

    @Column(name = "estado", length = 20)
    private String estado;

    @Column(name = "id_cuenta")
    private Integer id_cuenta;

    @Column(name = "usuario", length = 30)
    private String usuario;
}

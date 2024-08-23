package com.olpasa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "empresa_transporte")
public class EmpresaTransporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_et")
    private Integer codigoEt;

    @Column(name = "estado", length = 20)
    private String estado;

    @Column(name = "id_cuenta")
    private Integer idCuenta;

    @Column(name = "usuario", length = 30)
    private String usuario;
}

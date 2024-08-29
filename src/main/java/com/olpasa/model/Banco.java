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
@Table(name = "banco")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    @Column(name = "id_banco")
    private int idBanco;

    @Column(name = "nombre", length = 150)
    private String nombre;

}

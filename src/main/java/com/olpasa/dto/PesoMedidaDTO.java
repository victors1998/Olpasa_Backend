package com.olpasa.dto;

import com.olpasa.model.GuiaRemision;
import com.olpasa.model.Pesaje;
import com.olpasa.model.Vehiculo;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PesoMedidaDTO {

    private Integer id_peso_medida;
    private LocalDate fecha;
    private Pesaje id_pesaje;
    private GuiaRemision id_guia;
    private String estado;
    private String usuario;
    private Vehiculo id_vehiculo;
    private Vehiculo id_vehiculo2;

    @Column(columnDefinition = "DECIMAL(18,3)")
    private Integer peso_max_perm;

    @Column(columnDefinition = "DECIMAL(18,3)")
    private BigDecimal peso_bruto_transp;

    private String num_registro;
}

package com.olpasa.dto;

import com.olpasa.model.GuiaRemision;
import com.olpasa.model.Pesaje;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}

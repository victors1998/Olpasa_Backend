package com.olpasa.dto;

import com.olpasa.model.Pesaje;
import jakarta.persistence.Column;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ControlRffDto {

    private Integer id_control;

    private Pesaje id_pesaje;

    private String campaña;

    private String tipo_racimo;

    private String condicion;

    private String usuario;

}

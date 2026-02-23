package com.olpasa.repo;

import com.olpasa.dto.VehiculoDTO;
import com.olpasa.model.Vehiculo;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVehiculoRepo extends IGenericoRepo<Vehiculo, Integer> {

    @Query(value = "select v.id_vehiculo, CONCAT(p.nombres, ' ',p.paterno, ' ', p.materno) AS empresa,\n" +
            "  v.tipo, v.marca, v.estado, v.placa, v.alto, v.ancho, v.largo, v.constancia, \n" +
            "  v.configuracion_vehicular as configuracion, v.peso_max_permitido as permitido, v.codigo_et \n" +
            "  from vehiculo as v inner join persona as p on v.codigo_et=p.codigo", nativeQuery = true)
    List<VehiculoDTO> findVehiculos();
}

package com.olpasa.repo;

import com.olpasa.dto.EmpresaDTO;
import com.olpasa.dto.VehiculoDTO;
import com.olpasa.model.EmpresaTransporte;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEmpresaTransporteRepo extends IGenericoRepo<EmpresaTransporte, Integer>{

    @Query(value = "select e.codigo_et, CONCAT(p.paterno, ' ', p.materno, ' ', p.nombres) AS empresa,\n" +
            "  e.estado from empresa_transporte as e inner join persona AS P ON e.codigo_et=p.codigo", nativeQuery = true)
    List<EmpresaDTO> findEmpresaTransporte();
}

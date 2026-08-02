package com.olpasa.repo;

import com.olpasa.dto.SDTO;
import com.olpasa.model.Solicitud;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ISolicitudRepo extends IGenericoRepo<Solicitud, Integer> {

    @Query(value = "SELECT s.id_sol, s.serie, s.numero,  s.fecha, p.nombres+' '+p.paterno+' '+p.materno as solicitante,\n" +
            "s.estado, s.monto_solicitado, s.montoaprobado, s.fpag_sol, c.nomb_con, s.aprobado  FROM \n" +
            "solicitud AS s INNER JOIN proveedor as pr on s.idproveedor=pr.codigo INNER JOIN persona\n" +
            "as p on pr.codigo=p.codigo INNER JOIN concepto as c on s.id_con=c.id_con where s.estado='APROBADO'", nativeQuery = true)
    List<SDTO> solicitudesPendientes();
}

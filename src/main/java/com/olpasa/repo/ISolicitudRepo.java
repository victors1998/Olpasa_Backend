package com.olpasa.repo;

import com.olpasa.dto.SDTO;
import com.olpasa.model.Solicitud;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ISolicitudRepo extends IGenericoRepo<Solicitud, Integer> {

    @Query(value = "SELECT s.id_sol, s.serie, s.numero,  s.fecha, p.nombres+' '+p.paterno+' '+p.materno as solicitante,\n" +
            "s.estado, s.monto_solicitado, s.montoaprobado, s.fpag_sol, c.nomb_con, s.aprobado, b.nombre,\n" +
            "cb.numero as numero_cuenta, cb.cci FROM solicitud AS s \n" +
            "INNER JOIN proveedor as pr on s.idproveedor=pr.codigo \n" +
            "INNER JOIN persona as p on pr.codigo=p.codigo \n" +
            "INNER JOIN concepto as c on s.id_con=c.id_con\n" +
            "INNER JOIN cuenta_bancaria as cb on pr.id_cuenta=cb.id_cuenta \n" +
            "INNER JOIN banco as b on cb.id_banco=b.id_banco\n" +
            "where s.estado='APROBADO'", nativeQuery = true)
    List<SDTO> solicitudesPendientes();
}

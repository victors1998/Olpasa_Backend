package com.olpasa.repo;

import com.olpasa.model.Privilegio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IPrivilegioRepo extends IGenericoRepo<Privilegio, Integer>{

    @Query(value = """
                                         select p.* from usuario_privilegio as up
                                         inner join privilegio as p on up.id_privilegio=p.id_privilegio
                                         INNER JOIN usuario as u on u.nombre_cuenta=up.nombre_cuenta
                                         where u.nombre_cuenta= :nombre_cuenta
                  """, nativeQuery = true)
    List<Privilegio> getPrivilegioByUsername(@Param("nombre_cuenta") String nombre_cuenta);


}

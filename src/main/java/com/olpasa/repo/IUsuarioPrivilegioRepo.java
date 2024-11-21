package com.olpasa.repo;

import com.olpasa.model.UsuarioPrivilegio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUsuarioPrivilegioRepo extends IGenericoRepo<UsuarioPrivilegio, Integer>{

    @Query(value = """
                      select p.* from usuario_privilegio as up inner join
                      privilegio as p on up.id_privilegio=p.id_privilegio
                      where up.nombre_cuenta= :nombre_cuenta
                  """, nativeQuery = true)
    List<UsuarioPrivilegio> obtenerPrivilegiosPorUsuario(@Param("nombre_cuenta") String idUsuario);
}

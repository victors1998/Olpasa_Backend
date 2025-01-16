package com.olpasa.repo;

import com.olpasa.model.Menu;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMenuRepo extends IGenericoRepo<Menu, Integer>{

    @Query(value = """
                                           select m.* from menu_privilegio as mp
                                           inner join usuario_privilegio up on mp.id_privilegio=up.id_privilegio
                                		   inner join menu as m on m.id_menu=mp.id_menu
                                		   inner join usuario as u on u.nombre_cuenta=up.nombre_cuenta
                                		   where u.nombre_cuenta = :nombre_cuenta
        """, nativeQuery = true)
    List<Menu> getMenusByUsername(@Param("nombre_cuenta") String nombre_cuenta);
}

package com.olpasa.repo;

import com.olpasa.model.Usuario;
import org.springframework.data.jpa.repository.Query;

public interface IUsuarioRepo extends IGenericoRepo<Usuario, Integer>{

    @Query("FROM Usuario u WHERE u.nombre_cuenta = :nombre_cuenta")
    Usuario findOneByNombreCuenta(String nombre_cuenta);
}

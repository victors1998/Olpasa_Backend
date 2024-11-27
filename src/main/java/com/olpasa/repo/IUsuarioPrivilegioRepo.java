package com.olpasa.repo;

import com.olpasa.model.Privilegio;
import com.olpasa.model.UsuarioPrivilegio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUsuarioPrivilegioRepo extends IGenericoRepo<Privilegio, Integer>{

}

package com.olpasa.repo;

import com.olpasa.model.Pesaje;
import com.olpasa.model.Sector;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPesajeRepo extends IGenericoRepo<Pesaje, Integer> {

    @Query(value = "SELECT * FROM pesaje p WHERE estado='A' AND id_to=1", nativeQuery = true)
    List<Pesaje> leerPorEstado();
}

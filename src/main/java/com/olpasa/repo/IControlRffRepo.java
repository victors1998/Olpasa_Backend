package com.olpasa.repo;

import com.olpasa.model.ControlRff;
import com.olpasa.model.Pesaje;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IControlRffRepo extends IGenericoRepo<ControlRff, Integer> {

    @Query(value = "SELECT * FROM control_rff c WHERE id_pesaje=?1", nativeQuery = true)
    List<ControlRff> buscarIdPesaje(Integer id_pesaje);
}

package com.olpasa.service.impl;

import com.olpasa.dto.VehiculoDTO;
import com.olpasa.model.Vehiculo;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.repo.IVehiculoRepo;
import com.olpasa.service.IVehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculoServiceImpl extends CRUDImpl<Vehiculo, Integer> implements IVehiculoService {

    private final IVehiculoRepo vehiculoRepo;

    @Override
    protected IGenericoRepo<Vehiculo, Integer> getRepo() {
        return vehiculoRepo;
    }

    @Override
    public List<VehiculoDTO> findVehiculos() {
        return vehiculoRepo.findVehiculos();
    }
}

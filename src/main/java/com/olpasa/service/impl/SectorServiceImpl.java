package com.olpasa.service.impl;

import com.olpasa.model.Sector;
import com.olpasa.repo.ISectorRepo;
import com.olpasa.service.ISectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SectorServiceImpl implements ISectorService {

    private final ISectorRepo sectorRepo;

    @Override
    public Sector save(Sector sector) {
        return sectorRepo.save(sector);
    }

    @Override
    public Sector update(Integer id, Sector sector) {
        //FALTA AGREGAR VALIDACIONES
        return sectorRepo.save(sector);
    }

    @Override
    public List<Sector> findAll() {
        return sectorRepo.findAll();
    }

    @Override
    public Sector findById(Integer id) {
        return sectorRepo.findById(id).orElse(new Sector());
    }

    @Override
    public void delete(Integer id) {
        sectorRepo.deleteById(id);
    }
}

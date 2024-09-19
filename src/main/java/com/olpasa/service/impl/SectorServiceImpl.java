package com.olpasa.service.impl;

import com.olpasa.model.Sector;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.repo.ISectorRepo;
import com.olpasa.service.ISectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SectorServiceImpl extends CRUDImpl<Sector, Integer> implements ISectorService {

    private final ISectorRepo sectorRepo;

    @Override
    protected IGenericoRepo<Sector, Integer> getRepo() {
        return sectorRepo;
    }
}

package com.olpasa.service;

import com.olpasa.model.Sector;

import java.util.List;

public interface ISectorService {

    Sector save(Sector sector);

    Sector update(Integer id, Sector sector);

    List<Sector> findAll();

    Sector findById(Integer id);

    void delete(Integer id);
}

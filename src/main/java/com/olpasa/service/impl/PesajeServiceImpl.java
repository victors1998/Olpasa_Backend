package com.olpasa.service.impl;

import com.olpasa.dto.PesoDestare;
import com.olpasa.model.Pesaje;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.repo.IPesajeRepo;
import com.olpasa.service.IPesajeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PesajeServiceImpl extends CRUDImpl<Pesaje, Integer> implements IPesajeService {

    private final IPesajeRepo pesajeRepo;

    @Override
    protected IGenericoRepo<Pesaje, Integer> getRepo() {
        return pesajeRepo;
    }

    @Override
    public List<PesoDestare> findPesajeByEstado() {
        return pesajeRepo.findPesajeByEstado();
    }

    @Override
    public PesoDestare getPesajeById_pesaje(Integer id_pesaje) {
        return pesajeRepo.findPesajeById_pesaje(id_pesaje);
    }

    @Override
    public List<PesoDestare> searchProveedorAnioMes(Integer codigo, Integer anio, Integer mes) {
        return pesajeRepo.searchProveedorAnioMes(codigo, anio, mes);
    }

    @Override
    public List<PesoDestare> searchByDate(LocalDate date) {
        return pesajeRepo.searchByFecha(date);
    }

}

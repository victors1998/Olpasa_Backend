package com.olpasa.controller;

import com.olpasa.model.Sector;
import com.olpasa.service.ISectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sectores")
@RequiredArgsConstructor
public class SectorController {

    private final ISectorService sectorService;

    @GetMapping
    public List<Sector> findAll() {
        return sectorService.findAll();
    }

    @GetMapping("/{id}")
    public Sector findById(@PathVariable("id") Integer id) {
        return sectorService.findById(id);
    }

    @PostMapping
    public Sector save(@RequestBody Sector sector) {
        return sectorService.save(sector);
    }

}

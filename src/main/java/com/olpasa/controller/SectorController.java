package com.olpasa.controller;

import com.olpasa.model.Sector;
import com.olpasa.service.ISectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

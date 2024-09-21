package com.olpasa.controller;

import com.olpasa.dto.SectorDto;
import com.olpasa.model.Sector;
import com.olpasa.service.ISectorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/sectores")
@RequiredArgsConstructor
public class SectorController {

    private final ISectorService sectorService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<SectorDto>> findAll() {
        List<SectorDto> list = sectorService.findAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SectorDto> findById(@PathVariable("id") Integer id) {
        Sector obj = sectorService.findById(id);
        return ResponseEntity.ok(convertToDto(obj));
    }

    @PostMapping
    public ResponseEntity<SectorDto> save(@Valid @RequestBody SectorDto dto) {
        Sector obj = sectorService.save(convertToEntity(dto));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getIdSector()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<SectorDto> update(@Valid @PathVariable("id") Integer id, @RequestBody SectorDto dto) {

        dto.setIdSector(id);
        Sector obj = sectorService.update(id, convertToEntity(dto));
        return ResponseEntity.ok(convertToDto(obj));
    }

    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        sectorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private SectorDto convertToDto(Sector obj) {
        return modelMapper.map(obj, SectorDto.class);
    }

    private Sector convertToEntity(SectorDto dto) {
        return modelMapper.map(dto, Sector.class);
    }

}

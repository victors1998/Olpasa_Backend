package com.olpasa.controller;

import com.olpasa.dto.SectorDto;
import com.olpasa.model.Sector;
import com.olpasa.service.ISectorService;
import com.olpasa.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
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

    /*@Qualifier("defaultMapper")
    private final ModelMapper modelMapper;*/
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<SectorDto>> findAll() {
        //List<SectorDto> list = sectorService.findAll().stream().map(this::convertToDto).toList();
        List<SectorDto> list = mapperUtil.mapList(sectorService.findAll(), SectorDto.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SectorDto> findById(@PathVariable("id") Integer id) {
        Sector obj = sectorService.findById(id);
        //return ResponseEntity.ok(convertToDto(obj));
        return ResponseEntity.ok(mapperUtil.map(obj, SectorDto.class));
    }

    @PostMapping
    public ResponseEntity<SectorDto> save(@Valid @RequestBody SectorDto dto) {
        //Sector obj = sectorService.save(convertToEntity(dto));
        Sector obj = sectorService.save(mapperUtil.map(dto, Sector.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId_sector()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<SectorDto> update(@Valid @PathVariable("id") Integer id, @RequestBody SectorDto dto) {
        dto.setId_sector(id);
        //Sector obj = sectorService.update(id, convertToEntity(dto));
        Sector obj = sectorService.update(id, mapperUtil.map(dto, Sector.class));
        return ResponseEntity.ok(mapperUtil.map(obj, SectorDto.class));
    }

    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        sectorService.delete(id);
        return ResponseEntity.noContent().build();
    }

   /* private SectorDto convertToDto(Sector obj) {
        return modelMapper.map(obj, SectorDto.class);
    }

    private Sector convertToEntity(SectorDto dto) {
        return modelMapper.map(dto, Sector.class);
    }*/

}

package com.olpasa.controller;

import com.olpasa.dto.ConductorDto;
import com.olpasa.model.Conductor;
import com.olpasa.service.IConductorService;
import com.olpasa.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/conductores")
@RequiredArgsConstructor
public class ConductorController {

    private final IConductorService conductorService;

    /*@Qualifier("conductorMapper")
    private final ModelMapper modelMapper;*/

    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ConductorDto>> findAll() {
        List<ConductorDto> list = mapperUtil.mapList(conductorService.findAll(), ConductorDto.class, "conductorMapper");
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConductorDto> findById(@PathVariable("id") Integer id) {
        Conductor obj = conductorService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, ConductorDto.class, "conductorMapper"));
    }

    @PostMapping
    public ResponseEntity<ConductorDto> save(@Valid @RequestBody ConductorDto dto) {
        Conductor obj = conductorService.save(mapperUtil.map(dto, Conductor.class, "conductorMapper"));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getCodigo()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<ConductorDto> update(@Valid @PathVariable("id") Integer id, @RequestBody ConductorDto dto) {

        dto.setCodigo(id);
        Conductor obj = conductorService.update(id, mapperUtil.map(dto, Conductor.class, "conductorMapper"));
        return ResponseEntity.ok(mapperUtil.map(obj, ConductorDto.class, "conductorMapper"));
    }

    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        conductorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /*private ConductorDto convertToDto(Conductor obj) {
        return modelMapper.map(obj, ConductorDto.class);
    }

    private Conductor convertToEntity(ConductorDto dto) {
        return modelMapper.map(dto, Conductor.class);
    }*/

}

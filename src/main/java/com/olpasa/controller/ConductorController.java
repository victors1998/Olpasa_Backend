package com.olpasa.controller;

import com.olpasa.dto.ConductorDto;
import com.olpasa.model.Conductor;
import com.olpasa.service.IConductorService;
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
@RequestMapping("/conductores")
@RequiredArgsConstructor
public class ConductorController {

    private final IConductorService conductorService;

    @Qualifier("conductorMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ConductorDto>> findAll() {
        List<ConductorDto> list = conductorService.findAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConductorDto> findById(@PathVariable("id") Integer id) {
        Conductor obj = conductorService.findById(id);
        return ResponseEntity.ok(convertToDto(obj));
    }

    @PostMapping
    public ResponseEntity<ConductorDto> save(@Valid @RequestBody ConductorDto dto) {
        Conductor obj = conductorService.save(convertToEntity(dto));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getCodigo()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<ConductorDto> update(@Valid @PathVariable("id") Integer id, @RequestBody ConductorDto dto) {

        dto.setCodigo(id);
        Conductor obj = conductorService.update(id, convertToEntity(dto));
        return ResponseEntity.ok(convertToDto(obj));
    }

    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        conductorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private ConductorDto convertToDto(Conductor obj) {
        return modelMapper.map(obj, ConductorDto.class);
    }

    private Conductor convertToEntity(ConductorDto dto) {
        return modelMapper.map(dto, Conductor.class);
    }

}

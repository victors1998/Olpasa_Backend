package com.olpasa.controller;

import com.olpasa.dto.ClasificacionContableDto;
import com.olpasa.model.ClasificacionContable;
import com.olpasa.service.IClasificacionContableService;
import com.olpasa.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clasificacionContables")
@RequiredArgsConstructor
public class ClasificacionContableController {

    private final IClasificacionContableService clasificacionContableService;

    /*@Qualifier("defaultMapper")
    private final ModelMapper modelMapper;*/
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ClasificacionContableDto>> findAll() {
        //List<ClasificacionContableDto> list = clasificacionContableService.findAll().stream().map(this::convertToDto).toList();
        List<ClasificacionContableDto> list = mapperUtil.mapList(clasificacionContableService.findAll(), ClasificacionContableDto.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClasificacionContableDto> findById(@PathVariable("id") Integer id) {
        ClasificacionContable obj = clasificacionContableService.findById(id);
        //return ResponseEntity.ok(convertToDto(obj));
        return ResponseEntity.ok(mapperUtil.map(obj, ClasificacionContableDto.class));
    }

    @PostMapping
    public ResponseEntity<ClasificacionContableDto> save(@Valid @RequestBody ClasificacionContableDto dto) {
        //ClasificacionContable obj = clasificacionContableService.save(convertToEntity(dto));
        ClasificacionContable obj = clasificacionContableService.save(mapperUtil.map(dto, ClasificacionContable.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId_clasificacion()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<ClasificacionContableDto> update(@Valid @PathVariable("id") Integer id, @RequestBody ClasificacionContableDto dto) {
        dto.setId_clasificacion(id);
        //ClasificacionContable obj = clasificacionContableService.update(id, convertToEntity(dto));
        ClasificacionContable obj = clasificacionContableService.update(id, mapperUtil.map(dto, ClasificacionContable.class));
        return ResponseEntity.ok(mapperUtil.map(obj, ClasificacionContableDto.class));
    }

    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        clasificacionContableService.delete(id);
        return ResponseEntity.noContent().build();
    }

   /* private ClasificacionContableDto convertToDto(ClasificacionContable obj) {
        return modelMapper.map(obj, ClasificacionContableDto.class);
    }

    private ClasificacionContable convertToEntity(ClasificacionContableDto dto) {
        return modelMapper.map(dto, ClasificacionContable.class);
    }*/

}

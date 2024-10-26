package com.olpasa.controller;

import com.olpasa.dto.CriterioCalidadDto;
import com.olpasa.model.CriterioCalidad;
import com.olpasa.service.ICriterioCalidadService;
import com.olpasa.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/criterioCalidad")
@RequiredArgsConstructor
public class CriterioCalidadController {

    private final ICriterioCalidadService criterioCalidadService;

    /*@Qualifier("defaultMapper")
    private final ModelMapper modelMapper;*/
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<CriterioCalidadDto>> findAll() {
        //List<CriterioCalidadDto> list = criterioCalidadService.findAll().stream().map(this::convertToDto).toList();
        List<CriterioCalidadDto> list = mapperUtil.mapList(criterioCalidadService.findAll(), CriterioCalidadDto.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CriterioCalidadDto> findById(@PathVariable("id") Integer id) {
        CriterioCalidad obj = criterioCalidadService.findById(id);
        //return ResponseEntity.ok(convertToDto(obj));
        return ResponseEntity.ok(mapperUtil.map(obj, CriterioCalidadDto.class));
    }

    @PostMapping
    public ResponseEntity<CriterioCalidadDto> save(@Valid @RequestBody CriterioCalidadDto dto) {
        //CriterioCalidad obj = criterioCalidadService.save(convertToEntity(dto));
        CriterioCalidad obj = criterioCalidadService.save(mapperUtil.map(dto, CriterioCalidad.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getIdCriterio()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<CriterioCalidadDto> update(@Valid @PathVariable("id") Integer id, @RequestBody CriterioCalidadDto dto) {
        dto.setIdCriterio(id);
        //CriterioCalidad obj = criterioCalidadService.update(id, convertToEntity(dto));
        CriterioCalidad obj = criterioCalidadService.update(id, mapperUtil.map(dto, CriterioCalidad.class));
        return ResponseEntity.ok(mapperUtil.map(obj, CriterioCalidadDto.class));
    }

    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        criterioCalidadService.delete(id);
        return ResponseEntity.noContent().build();
    }

   /* private CriterioCalidadDto convertToDto(CriterioCalidad obj) {
        return modelMapper.map(obj, CriterioCalidadDto.class);
    }

    private CriterioCalidad convertToEntity(CriterioCalidadDto dto) {
        return modelMapper.map(dto, CriterioCalidad.class);
    }*/

}

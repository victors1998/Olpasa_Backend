package com.olpasa.controller;

import com.olpasa.dto.EvaluacionCalidadDto;
import com.olpasa.model.EvaluacionCalidad;
import com.olpasa.service.IEvaluacionCalidadService;
import com.olpasa.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/evaluacion_calidad")
@RequiredArgsConstructor
public class EvaluacionCalidadController {

    private final IEvaluacionCalidadService evaluacionCalidadService;

    /*@Qualifier("defaultMapper")
    private final ModelMapper modelMapper;*/
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<EvaluacionCalidadDto>> findAll() {
        //List<EvaluacionCalidadDto> list = evaluacionCalidadService.findAll().stream().map(this::convertToDto).toList();
        List<EvaluacionCalidadDto> list = mapperUtil.mapList(evaluacionCalidadService.findAll(), EvaluacionCalidadDto.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<List<EvaluacionCalidadDto>> findByIdPesaje(@PathVariable("id") Integer id) {
        List<EvaluacionCalidad> list = evaluacionCalidadService.findByIdPesaje(id);
        List<EvaluacionCalidadDto> listDto = mapperUtil.mapList(list, EvaluacionCalidadDto.class);
        return ResponseEntity.ok(listDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvaluacionCalidadDto> findById(@PathVariable("id") Integer id) {
        EvaluacionCalidad obj = evaluacionCalidadService.findById(id);
        //return ResponseEntity.ok(convertToDto(obj));
        return ResponseEntity.ok(mapperUtil.map(obj, EvaluacionCalidadDto.class));
    }

    @PostMapping
    public ResponseEntity<EvaluacionCalidadDto> save(@Valid @RequestBody EvaluacionCalidadDto dto) {
        //EvaluacionCalidad obj = evaluacionCalidadService.save(convertToEntity(dto));
        EvaluacionCalidad obj = evaluacionCalidadService.save(mapperUtil.map(dto, EvaluacionCalidad.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId_evaluacion()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/delete")
    public ResponseEntity<EvaluacionCalidadDto> update(@Valid @PathVariable("id") Integer id, @RequestBody EvaluacionCalidadDto dto) {
        dto.setId_evaluacion(id);
        //EvaluacionCalidad obj = evaluacionCalidadService.update(id, convertToEntity(dto));
        EvaluacionCalidad obj = evaluacionCalidadService.update(id, mapperUtil.map(dto, EvaluacionCalidad.class));
        return ResponseEntity.ok(mapperUtil.map(obj, EvaluacionCalidadDto.class));
    }

    @PutMapping
    public ResponseEntity<EvaluacionCalidadDto> eliminarEvaluacionCalidad(@Valid @PathVariable("id") Integer id_evaluacion, @RequestBody EvaluacionCalidadDto dto) {
        dto.setId_evaluacion(id_evaluacion);
        //EvaluacionCalidad obj = evaluacionCalidadService.update(id, convertToEntity(dto));
        EvaluacionCalidad obj = evaluacionCalidadService.update(id_evaluacion, mapperUtil.map(dto, EvaluacionCalidad.class));
        return ResponseEntity.ok(mapperUtil.map(obj, EvaluacionCalidadDto.class));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        evaluacionCalidadService.delete(id);
        return ResponseEntity.noContent().build();
    }

   /* private EvaluacionCalidadDto convertToDto(EvaluacionCalidad obj) {
        return modelMapper.map(obj, EvaluacionCalidadDto.class);
    }

    private EvaluacionCalidad convertToEntity(EvaluacionCalidadDto dto) {
        return modelMapper.map(dto, EvaluacionCalidad.class);
    }*/

}

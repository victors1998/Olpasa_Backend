package com.olpasa.controller;

import com.olpasa.dto.ClasificacionDto;
import com.olpasa.model.Clasificacion;
import com.olpasa.service.IClasificacionService;
import com.olpasa.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clasificaciones")
@RequiredArgsConstructor
public class ClasificacionController {

    private final IClasificacionService clasificacionService;

    /*@Qualifier("defaultMapper")
    private final ModelMapper modelMapper;*/
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ClasificacionDto>> findAll() {
        //List<ClasificacionDto> list = clasificacionService.findAll().stream().map(this::convertToDto).toList();
        List<ClasificacionDto> list = mapperUtil.mapList(clasificacionService.findAll(), ClasificacionDto.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClasificacionDto> findById(@PathVariable("id") Integer id) {
        Clasificacion obj = clasificacionService.findById(id);
        //return ResponseEntity.ok(convertToDto(obj));
        return ResponseEntity.ok(mapperUtil.map(obj, ClasificacionDto.class));
    }

    @PostMapping
    public ResponseEntity<ClasificacionDto> save(@Valid @RequestBody ClasificacionDto dto) {
        //Clasificacion obj = clasificacionService.save(convertToEntity(dto));
        Clasificacion obj = clasificacionService.save(mapperUtil.map(dto, Clasificacion.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId_clas()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<ClasificacionDto> update(@Valid @PathVariable("id") Integer id, @RequestBody ClasificacionDto dto) {
        dto.setId_clas(id);
        //Clasificacion obj = clasificacionService.update(id, convertToEntity(dto));
        Clasificacion obj = clasificacionService.update(id, mapperUtil.map(dto, Clasificacion.class));
        return ResponseEntity.ok(mapperUtil.map(obj, ClasificacionDto.class));
    }

    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        clasificacionService.delete(id);
        return ResponseEntity.noContent().build();
    }

   /* private ClasificacionDto convertToDto(Clasificacion obj) {
        return modelMapper.map(obj, ClasificacionDto.class);
    }

    private Clasificacion convertToEntity(ClasificacionDto dto) {
        return modelMapper.map(dto, Clasificacion.class);
    }*/

}

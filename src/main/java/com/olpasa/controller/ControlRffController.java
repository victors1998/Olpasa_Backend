package com.olpasa.controller;

import com.olpasa.dto.ControlRffDto;
import com.olpasa.model.ControlRff;
import com.olpasa.service.IControlRffService;
import com.olpasa.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/controlrff")
@RequiredArgsConstructor
public class ControlRffController {

    private final IControlRffService controlRffService;

    /*@Qualifier("defaultMapper")
    private final ModelMapper modelMapper;*/
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ControlRffDto>> findAll() {
        //List<ControlRffDto> list = controlRffService.findAll().stream().map(this::convertToDto).toList();
        List<ControlRffDto> list = mapperUtil.mapList(controlRffService.findAll(), ControlRffDto.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ControlRffDto> findById(@PathVariable("id") Integer id) {
        ControlRff obj = controlRffService.findById(id);
        //return ResponseEntity.ok(convertToDto(obj));
        return ResponseEntity.ok(mapperUtil.map(obj, ControlRffDto.class));
    }

    @GetMapping("/buscar/{id_pesaje}")
    public ResponseEntity<ControlRffDto> findByIdPesaje(@PathVariable("id_pesaje") Integer id_pesaje) {
        ControlRff obj = controlRffService.buscarPorIdPesaje(id_pesaje);
        //return ResponseEntity.ok(convertToDto(obj));
        return ResponseEntity.ok(mapperUtil.map(obj, ControlRffDto.class));
    }

    @PostMapping
    public ResponseEntity<ControlRffDto> save(@Valid @RequestBody ControlRffDto dto) {
        //ControlRff obj = controlRffService.save(convertToEntity(dto));
        ControlRff obj = controlRffService.save(mapperUtil.map(dto, ControlRff.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId_control()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ControlRffDto> update(@Valid @PathVariable("id") Integer id, @RequestBody ControlRffDto dto) {
        dto.setId_control(id);
        //ControlRff obj = controlRffService.update(id, convertToEntity(dto));
        ControlRff obj = controlRffService.update(id, mapperUtil.map(dto, ControlRff.class));
        return ResponseEntity.ok(mapperUtil.map(obj, ControlRffDto.class));
    }

    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        controlRffService.delete(id);
        return ResponseEntity.noContent().build();
    }

   /* private ControlRffDto convertToDto(ControlRff obj) {
        return modelMapper.map(obj, ControlRffDto.class);
    }

    private ControlRff convertToEntity(ControlRffDto dto) {
        return modelMapper.map(dto, ControlRff.class);
    }*/

}

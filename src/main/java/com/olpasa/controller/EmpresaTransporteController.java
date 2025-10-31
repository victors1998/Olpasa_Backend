package com.olpasa.controller;

import com.olpasa.dto.EmpresaDTO;
import com.olpasa.dto.EmpresaTransporteDto;
import com.olpasa.model.EmpresaTransporte;
import com.olpasa.service.IEmpresaTransporteService;
import com.olpasa.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/empresaTransportes")
@RequiredArgsConstructor
public class EmpresaTransporteController {

    private final IEmpresaTransporteService empresaTransporteService;

    /*@Qualifier("defaultMapper")
    private final ModelMapper modelMapper;*/
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<EmpresaTransporteDto>> findAll() {
        //List<EmpresaTransporteDto> list = empresaTransporteService.findAll().stream().map(this::convertToDto).toList();
        List<EmpresaTransporteDto> list = mapperUtil.mapList(empresaTransporteService.findAll(), EmpresaTransporteDto.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<EmpresaDTO>> buscarEmpresa() {
        List<EmpresaDTO> list = mapperUtil.mapList(empresaTransporteService.findEmpresaTransporte(), EmpresaDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaTransporteDto> findById(@PathVariable("id") Integer id) {
        EmpresaTransporte obj = empresaTransporteService.findById(id);
        //return ResponseEntity.ok(convertToDto(obj));
        return ResponseEntity.ok(mapperUtil.map(obj, EmpresaTransporteDto.class, "empresaTransporteMapper"));
    }

    @PostMapping
    public ResponseEntity<EmpresaTransporteDto> save(@Valid @RequestBody EmpresaTransporteDto dto) {
        //EmpresaTransporte obj = empresaTransporteService.save(convertToEntity(dto));
        EmpresaTransporte obj = empresaTransporteService.save(mapperUtil.map(dto, EmpresaTransporte.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getCodigo_et()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<EmpresaTransporteDto> update(@Valid @PathVariable("id") Integer id, @RequestBody EmpresaTransporteDto dto) {
        dto.setCodigo_et(id);
        //EmpresaTransporte obj = empresaTransporteService.update(id, convertToEntity(dto));
        EmpresaTransporte obj = empresaTransporteService.update(id, mapperUtil.map(dto, EmpresaTransporte.class));
        return ResponseEntity.ok(mapperUtil.map(obj, EmpresaTransporteDto.class));
    }

    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        empresaTransporteService.delete(id);
        return ResponseEntity.noContent().build();
    }

   /* private EmpresaTransporteDto convertToDto(EmpresaTransporte obj) {
        return modelMapper.map(obj, EmpresaTransporteDto.class);
    }

    private EmpresaTransporte convertToEntity(EmpresaTransporteDto dto) {
        return modelMapper.map(dto, EmpresaTransporte.class);
    }*/

}

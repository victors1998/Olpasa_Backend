package com.olpasa.controller;

import com.olpasa.dto.PesajeDto;
import com.olpasa.model.Pesaje;
import com.olpasa.service.IPesajeService;
import com.olpasa.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pesajes")
@RequiredArgsConstructor
public class PesajeController {

    private final IPesajeService pesajeService;

    /*@Qualifier("defaultMapper")
    private final ModelMapper modelMapper;*/
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<PesajeDto>> findAll() {
        //List<PesajeDto> list = pesajeService.findAll().stream().map(this::convertToDto).toList();
        List<PesajeDto> list = mapperUtil.mapList(pesajeService.findAll(), PesajeDto.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id_pesaje}")
    public ResponseEntity<PesajeDto> findById(@PathVariable("id_pesaje") Integer id_pesaje) {
        Pesaje obj = pesajeService.findById(id_pesaje);
        //List<PesajeDto> listDto = mapperUtil.mapList(list, PesajeDto.class);
        return ResponseEntity.ok(mapperUtil.map(obj, PesajeDto.class));
    }

   /* @GetMapping("/{id_pesaje1}")
    public ResponseEntity<List<PesajeDto>> findById1(@PathVariable("id_pesaje") Integer id_pesaje) {
        List<Pesaje> list = pesajeService.buscarPorIdPesaje(id_pesaje);
        List<PesajeDto> listDto = mapperUtil.mapList(list, PesajeDto.class);
       return ResponseEntity.ok(listDto);
  }*/

   /* @GetMapping("/destarar")
    public ResponseEntity<List<PesajeDto>> destarar() {
        //List<PesajeDto> list = pesajeService.findAll().stream().map(this::convertToDto).toList();
        List<PesajeDto> list = mapperUtil.mapList(pesajeService.listarPorEstado(), PesajeDto.class);
        return ResponseEntity.ok(list);
    }*/

    @GetMapping("/destarar")
    public ResponseEntity<List<PesajeDto>> destarar() {
        List<PesajeDto> list = mapperUtil.mapList(pesajeService.findPesajeByEstado(), PesajeDto.class);
        return ResponseEntity.ok(list);
    }



    @PostMapping
    public ResponseEntity<PesajeDto> save(@Valid @RequestBody PesajeDto dto) {
        //Pesaje obj = pesajeService.save(convertToEntity(dto));
        Pesaje obj = pesajeService.save(mapperUtil.map(dto, Pesaje.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId_pesaje()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<PesajeDto> update(@Valid @PathVariable("id") Integer id, @RequestBody PesajeDto dto) {
        dto.setId_pesaje(id);
        //Pesaje obj = pesajeService.update(id, convertToEntity(dto));
        Pesaje obj = pesajeService.update(id, mapperUtil.map(dto, Pesaje.class));
        return ResponseEntity.ok(mapperUtil.map(obj, PesajeDto.class));
    }

    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        pesajeService.delete(id);
        return ResponseEntity.noContent().build();
    }

   /* private PesajeDto convertToDto(Pesaje obj) {
        return modelMapper.map(obj, PesajeDto.class);
    }

    private Pesaje convertToEntity(PesajeDto dto) {
        return modelMapper.map(dto, Pesaje.class);
    }*/

}

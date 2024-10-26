package com.olpasa.controller;

import com.olpasa.dto.BancoDto;
import com.olpasa.model.Banco;
import com.olpasa.service.IBancoService;
import com.olpasa.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bancos")
@RequiredArgsConstructor
public class BancoController {

    private final IBancoService bancoService;

    /*@Qualifier("defaultMapper")
    private final ModelMapper modelMapper;*/
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<BancoDto>> findAll() {
        //List<BancoDto> list = bancoService.findAll().stream().map(this::convertToDto).toList();
        List<BancoDto> list = mapperUtil.mapList(bancoService.findAll(), BancoDto.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BancoDto> findById(@PathVariable("id") Integer id) {
        Banco obj = bancoService.findById(id);
        //return ResponseEntity.ok(convertToDto(obj));
        return ResponseEntity.ok(mapperUtil.map(obj, BancoDto.class));
    }

    @PostMapping
    public ResponseEntity<BancoDto> save(@Valid @RequestBody BancoDto dto) {
        //Banco obj = bancoService.save(convertToEntity(dto));
        Banco obj = bancoService.save(mapperUtil.map(dto, Banco.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getIdBanco()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<BancoDto> update(@Valid @PathVariable("id") Integer id, @RequestBody BancoDto dto) {
        dto.setIdBanco(id);
        //Banco obj = bancoService.update(id, convertToEntity(dto));
        Banco obj = bancoService.update(id, mapperUtil.map(dto, Banco.class));
        return ResponseEntity.ok(mapperUtil.map(obj, BancoDto.class));
    }

    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        bancoService.delete(id);
        return ResponseEntity.noContent().build();
    }

   /* private BancoDto convertToDto(Banco obj) {
        return modelMapper.map(obj, BancoDto.class);
    }

    private Banco convertToEntity(BancoDto dto) {
        return modelMapper.map(dto, Banco.class);
    }*/

}

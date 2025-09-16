package com.olpasa.controller;

import com.olpasa.dto.BancoDto;
import com.olpasa.dto.ProveedorDTO;
import com.olpasa.model.Banco;
import com.olpasa.model.Proveedor;
import com.olpasa.service.IProveedorService;
import com.olpasa.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/proveedor")
@RequiredArgsConstructor
public class ProveedorController {

    private final IProveedorService proveedorService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<ProveedorDTO>> findAll() {
        //List<BancoDto> list = bancoService.findAll().stream().map(this::convertToDto).toList();
        List<ProveedorDTO> list = mapperUtil.mapList(proveedorService.findAll(), ProveedorDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ProveedorDTO> findById(@PathVariable("codigo") Integer codigo) {
        Proveedor obj = proveedorService.findById(codigo);
        //return ResponseEntity.ok(convertToDto(obj));
        return ResponseEntity.ok(mapperUtil.map(obj, ProveedorDTO.class));
    }
}

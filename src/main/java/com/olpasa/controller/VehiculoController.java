package com.olpasa.controller;

import com.olpasa.dto.SectorDto;
import com.olpasa.dto.VDTO;
import com.olpasa.dto.VehiculoDTO;
import com.olpasa.model.Sector;
import com.olpasa.model.Vehiculo;
import com.olpasa.service.IVehiculoService;
import com.olpasa.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/vehiculos")
@RequiredArgsConstructor
public class VehiculoController {

    private final IVehiculoService vehiculoService;
    private final MapperUtil mapperUtil;

    @GetMapping("/buscar")
    public ResponseEntity<List<VehiculoDTO>> findVehiculos() {
        List<VehiculoDTO> list = mapperUtil.mapList(vehiculoService.findVehiculos(), VehiculoDTO.class);
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<VDTO> save(@Valid @RequestBody VDTO dto) {
        Vehiculo obj = vehiculoService.save(mapperUtil.map(dto, Vehiculo.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId_vehiculo()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id_vehiculo}")
    public ResponseEntity<VDTO> update(@Valid @PathVariable("id_vehiculo") Integer id_vehiculo, @RequestBody VDTO dto) {
        dto.setId_vehiculo(id_vehiculo);
        Vehiculo obj = vehiculoService.update(id_vehiculo, mapperUtil.map(dto, Vehiculo.class));
        return ResponseEntity.ok(mapperUtil.map(obj, VDTO.class));
    }
}

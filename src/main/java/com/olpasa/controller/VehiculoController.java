package com.olpasa.controller;

import com.olpasa.dto.VehiculoDTO;
import com.olpasa.service.IVehiculoService;
import com.olpasa.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

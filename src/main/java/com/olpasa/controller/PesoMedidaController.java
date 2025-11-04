package com.olpasa.controller;

import com.olpasa.dto.PMDto;
import com.olpasa.dto.PesoDestare;
import com.olpasa.dto.PesoMedidaDTO;
import com.olpasa.dto.VDTO;
import com.olpasa.model.PesoMedida;
import com.olpasa.model.Vehiculo;
import com.olpasa.service.IPesoMedidaService;
import com.olpasa.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/peso_medidas")
@RequiredArgsConstructor
public class PesoMedidaController {

    private final IPesoMedidaService pesoMedidaService;
    private final MapperUtil mapperUtil;

    @GetMapping("/search/date")
    public ResponseEntity<List<PMDto>> buscarByFecha(@RequestParam(value = "date", defaultValue = "2024-08-01") String date) {
        LocalDate fecha = LocalDate.parse(date);
        List<PMDto> lis = mapperUtil.mapList(pesoMedidaService.searchByDate(fecha), PMDto.class);
        return ResponseEntity.ok(lis);
    }

    @PostMapping
    public ResponseEntity<PMDto> save(@Valid @RequestBody PMDto dto) {
        PesoMedida obj = pesoMedidaService.save(mapperUtil.map(dto, PesoMedida.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId_peso_medida()).toUri();
        return ResponseEntity.created(location).build();
    }

}

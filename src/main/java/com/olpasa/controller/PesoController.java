package com.olpasa.controller;

import com.olpasa.dto.PesajeDto;
import com.olpasa.dto.PesoDestare;
import com.olpasa.dto.PesoDto;
import com.olpasa.model.Pesaje;
import com.olpasa.service.IPesajeService;
import com.olpasa.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/peso")
@RequiredArgsConstructor
public class PesoController {

    private final IPesajeService pesajeService;
    private final MapperUtil mapperUtil;

    @GetMapping("/destarar")
    public ResponseEntity<List<PesoDto>> destarar() {
        List<PesoDto> list = mapperUtil.mapList(pesajeService.findPesajeByEstado(), PesoDto.class);
        //var list = pesajeService.findPesajeByEstado();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id_pesaje}")
    public ResponseEntity<PesoDestare> findById_pesaje(@PathVariable("id_pesaje") Integer id_pesaje) {
        PesoDestare list = pesajeService.getPesajeById_pesaje(id_pesaje);
        //List<PesajeDto> listDto = mapperUtil.mapList(list, PesajeDto.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/buscar/{codigo}/{anio}/{mes}")
    public ResponseEntity<List<PesoDestare>> buscarCodigoAnioMes(@PathVariable Integer codigo, @PathVariable Integer anio, @PathVariable Integer mes) {
        List<PesoDestare> lis = mapperUtil.mapList(pesajeService.searchProveedorAnioMes(codigo, anio, mes), PesoDestare.class);
        return ResponseEntity.ok(lis);
    }

    @GetMapping("/search/date")
    public ResponseEntity<List<PesoDestare>> buscarByFecha(@RequestParam(value = "date", defaultValue = "2024-08-01") String date) {
        LocalDateTime fecha = LocalDateTime.parse(date);
        List<PesoDestare> lis = mapperUtil.mapList(pesajeService.searchByDate(fecha), PesoDestare.class);
        return ResponseEntity.ok(lis);
    }
}

package com.olpasa.controller;

import com.olpasa.dto.PesajeDto;
import com.olpasa.dto.PesoDestare;
import com.olpasa.dto.PesoDto;
import com.olpasa.model.Pesaje;
import com.olpasa.service.IPesajeService;
import com.olpasa.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

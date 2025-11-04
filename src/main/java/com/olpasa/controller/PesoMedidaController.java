package com.olpasa.controller;

import com.olpasa.dto.PMDto;
import com.olpasa.dto.PesoDestare;
import com.olpasa.service.IPesoMedidaService;
import com.olpasa.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}

package com.olpasa.controller;

import com.olpasa.dto.*;
import com.olpasa.service.IGuiaRemisionService;
import com.olpasa.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/guia_remision")
@RequiredArgsConstructor
public class GuiaRemisionController {

    private final IGuiaRemisionService guiaRemisionService;
    private final MapperUtil mapperUtil;

    @GetMapping("/facturado")
    public ResponseEntity<List<GuiaRemisionDTO>> BuscarGuiaRemisionFacturado() {
        List<GuiaRemisionDTO> list = mapperUtil.mapList(guiaRemisionService.findGuiaRemisionFacturado(), GuiaRemisionDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/buscar/{facturado}/{serie}/{numero}")
    public ResponseEntity<List<GuiaDTO>> buscarGuiaRemisonSerieNumero(@PathVariable("facturado") String facturado, @PathVariable("serie") String serie, @PathVariable("numero") Integer numero) {
        List<GuiaDTO> lis = mapperUtil.mapList(guiaRemisionService.findGuiaRemisionSerieNumero(facturado, serie, numero), GuiaDTO.class);
        return ResponseEntity.ok(lis);
    }

    @GetMapping("/search/date")
    public ResponseEntity<List<GuiaDTO>> buscarByFecha(@RequestParam(value = "date", defaultValue = "2024-08-01") String date) {
        LocalDate fecha = LocalDate.parse(date);
        List<GuiaDTO> lis = mapperUtil.mapList(guiaRemisionService.searchByDate(fecha), GuiaDTO.class);
        return ResponseEntity.ok(lis);
    }

}

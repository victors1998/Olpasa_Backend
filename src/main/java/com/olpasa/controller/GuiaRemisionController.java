package com.olpasa.controller;

import com.olpasa.dto.GuiaRemisionDTO;
import com.olpasa.dto.PesajeDto;
import com.olpasa.dto.PesoDestare;
import com.olpasa.dto.PesoDto;
import com.olpasa.service.IGuiaRemisionService;
import com.olpasa.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<GuiaRemisionDTO>> buscarGuiaRemisonSerieNumero(@PathVariable("facturado") String facturado, @PathVariable("serie") String serie, @PathVariable("numero") Integer numero) {
        List<GuiaRemisionDTO> lis = mapperUtil.mapList(guiaRemisionService.findGuiaRemisionSerieNumero(facturado, serie, numero), GuiaRemisionDTO.class);
        return ResponseEntity.ok(lis);
    }

}

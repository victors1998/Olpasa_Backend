package com.olpasa.controller;

import com.olpasa.dto.SDTO;
import com.olpasa.dto.SolicitudDTO;
import com.olpasa.service.ISolicitudSevice;
import com.olpasa.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitud")
@RequiredArgsConstructor
public class SolicitudController {

    private final ISolicitudSevice solicitudService;

    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<SDTO>> findAll() {
        List<SDTO> list = mapperUtil.mapList(solicitudService.solicitudesPendientes(), SDTO.class);
        return ResponseEntity.ok(list);
    }

    @PostMapping("/solicitudes")
    public ResponseEntity<byte[]> generarReporte(@RequestBody List<SolicitudDTO> solicitudes) throws Exception {
        byte[] pdf = solicitudService.generarReporte(solicitudes);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=ReporteSolicitudes.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }

}

package com.olpasa.controller;

import com.olpasa.dto.SDTO;
import com.olpasa.service.ISolicitudSevice;
import com.olpasa.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

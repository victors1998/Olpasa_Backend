package com.olpasa.controller;

import com.olpasa.dto.*;
import com.olpasa.model.PesoMedida;
import com.olpasa.model.Sector;
import com.olpasa.model.Vehiculo;
import com.olpasa.service.IPesoMedidaService;
import com.olpasa.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @GetMapping("/{id}")
    public ResponseEntity<PesoMedidaDTO> findById(@PathVariable("id") Integer id) {
        PesoMedida obj = pesoMedidaService.findById(id);
        //return ResponseEntity.ok(convertToDto(obj));
        return ResponseEntity.ok(mapperUtil.map(obj, PesoMedidaDTO.class));
    }

    @GetMapping("/search/date")
    public ResponseEntity<List<PMDto>> buscarByFecha(@RequestParam(value = "date", defaultValue = "2024-08-01") String date) {
        LocalDate fecha = LocalDate.parse(date);
        List<PMDto> lis = mapperUtil.mapList(pesoMedidaService.searchByDate(fecha), PMDto.class);
        return ResponseEntity.ok(lis);
    }

    @PostMapping
    public ResponseEntity<PesoMedidaDTO> save(@Valid @RequestBody PesoMedidaDTO dto) {
        PesoMedida obj = pesoMedidaService.save(mapperUtil.map(dto, PesoMedida.class));
        System.out.println("✅ Nueva ID registrada: " + obj.getId_peso_medida());
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId_peso_medida())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/buscar/{id_peso_medida}")
    public ResponseEntity<PMDto> buscarByIdPesoMedida(@PathVariable("id_peso_medida") Integer id_peso_medida) {
        PMDto obj = pesoMedidaService.searchByIdPesoMedida(id_peso_medida);
        return ResponseEntity.ok(mapperUtil.map(obj, PMDto.class));
    }

    @GetMapping(value = "/generateReport/{id_peso_medida}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE) //APPLICATION_PDF_VALUE
    public ResponseEntity<byte[]> generateReport(@PathVariable("id_peso_medida") Integer id_peso_medida) throws Exception{
        byte[] data = pesoMedidaService.generateReport(id_peso_medida);

        return ResponseEntity.ok(data);
    }

    // Endpoint para anular un registro por ID
    @PutMapping("/{id}/anular")
    public ResponseEntity<String> anular(@PathVariable("id") Integer idPesoMedida) {
        int filas = pesoMedidaService.anularById(idPesoMedida);

        if (filas > 0) {
            return ResponseEntity.ok("Registro con ID " + idPesoMedida + " anulado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró el registro con ID " + idPesoMedida);
        }
    }

    @GetMapping(value = "/pdf/{id_peso_medida}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generarPdf(@PathVariable Integer id_peso_medida) throws  Exception {
        byte[] data = pesoMedidaService.generateReport(id_peso_medida);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/existe/{id_guia}")
    public ResponseEntity<Boolean> existsByGuia(@PathVariable Integer id_guia) {
        return ResponseEntity.ok(pesoMedidaService.existsByGuia(id_guia));
    }

}

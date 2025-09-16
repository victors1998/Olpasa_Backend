package com.olpasa.controller;

import com.olpasa.dto.PersonaDTO;
import com.olpasa.dto.ProveedorDTO;
import com.olpasa.service.IPersonaService;
import com.olpasa.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personas")
@RequiredArgsConstructor
public class PersonaController {

    private final IPersonaService personaService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<PersonaDTO>> findAll() {
        List<PersonaDTO> list = mapperUtil.mapList(personaService.findAll(), PersonaDTO.class);
        return ResponseEntity.ok(list);
    }
}

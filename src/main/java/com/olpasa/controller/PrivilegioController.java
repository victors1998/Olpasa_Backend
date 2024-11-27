package com.olpasa.controller;

import com.olpasa.dto.PrivilegioDto;
import com.olpasa.service.IPrivilegioService;
import com.olpasa.service.IUsuarioPrivilegioService;
import com.olpasa.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/privilegios")
@RequiredArgsConstructor
public class PrivilegioController {

    private final IPrivilegioService privilegioService;

    private final MapperUtil mapperUtil;

    @PostMapping("/user")
    public ResponseEntity<List<PrivilegioDto>> getusuarioPrivilegioByUsuario(@RequestBody String nombre_cuenta) {
        List<PrivilegioDto> privilegioDto = mapperUtil.mapList(privilegioService.getUsuarioPrivilegiosPorNombre(nombre_cuenta), PrivilegioDto.class);
        return ResponseEntity.ok(privilegioDto);
    }
}

package com.olpasa.controller;

import com.olpasa.dto.UsuarioPrivilegioDto;
import com.olpasa.model.UsuarioPrivilegio;
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
public class UsuarioPrivilegioController {

    private final IUsuarioPrivilegioService usuarioPrivilegioService;

    private final MapperUtil mapperUtil;

    @PostMapping("/user")
    public ResponseEntity<List<UsuarioPrivilegioDto>> getusuarioPrivilegioByUsuario(@RequestBody String username) {
        List<UsuarioPrivilegioDto> usuario_privilegioDto = mapperUtil.mapList(usuarioPrivilegioService.getUsuarioPrivilegiosPorNombre(username), UsuarioPrivilegioDto.class);
        return ResponseEntity.ok(usuario_privilegioDto);
    }
}

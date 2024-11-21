package com.olpasa.controller;

import com.olpasa.model.UsuarioPrivilegio;
import com.olpasa.service.IUsuarioPrivilegioService;
import com.olpasa.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuario_privilegio")
@RequiredArgsConstructor
public class UsuarioPrivilegioController {

    private final IUsuarioPrivilegioService usuarioPrivilegioService;

    private final MapperUtil mapperUtil;

    @PostMapping("/usuario")
    public ResponseEntity<List<UsuarioPrivilegio>> getusuarioPrivilegioByUsuario() {
        return null;
    }
}

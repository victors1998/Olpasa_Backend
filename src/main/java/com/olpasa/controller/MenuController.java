package com.olpasa.controller;

import com.olpasa.dto.MenuDTO;
import com.olpasa.dto.PrivilegioDto;
import com.olpasa.service.IMenuService;
import com.olpasa.service.IPrivilegioService;
import com.olpasa.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {

    private final IMenuService menuService;

    private final MapperUtil mapperUtil;

    @PostMapping("/user")
    public ResponseEntity<List<MenuDTO>> getMenuByNombreUsuario(@RequestBody String nombre_cuenta) {  //@RequestBody String nombre_cuenta
        // List<PrivilegioDto> privilegioDto = mapperUtil.mapList(privilegioService.getUsuarioPrivilegiosPorNombre(nombre_cuenta), PrivilegioDto.class);
        List<MenuDTO> menuDTO = mapperUtil.mapList(menuService.getMenusByUsername(nombre_cuenta), MenuDTO.class);
        return ResponseEntity.ok(menuDTO);
    }
}

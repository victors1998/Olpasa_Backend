package com.olpasa.controller;

import com.olpasa.service.IGuiaRemisionService;
import com.olpasa.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bancos")
@RequiredArgsConstructor
public class GuiaRemisionController {

    private final IGuiaRemisionService guiaRemisionService;
    private final MapperUtil mapperUtil;


}

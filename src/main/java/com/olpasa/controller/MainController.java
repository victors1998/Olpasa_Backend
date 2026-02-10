package com.olpasa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
/*

    @GetMapping(value = { "/",  "/app/**"}) //
    //@ResponseBody
    public String  index() {
        return "index";
    }
*/
    @GetMapping("/pages/**")
    //@ResponseBody
    public String  welcome() {
        return "index";
    }

    @GetMapping("/login")
    //@ResponseBody
    public String  login() {
        return "index";
    }

}
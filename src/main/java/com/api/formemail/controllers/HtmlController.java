package com.api.formemail.controllers;

import com.api.formemail.models.EmailFormulario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HtmlController {

    @GetMapping("/formulario")
    public String exibirForm(){
        return "formTest";
    }
}

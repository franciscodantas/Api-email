package com.api.formemail.controllers;

import com.api.formemail.models.EmailFormulario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "/formulario")
public class EmailController {

    @Autowired
    private JavaMailSender emailSender;

    @PostMapping("/enviar-email")
    public ResponseEntity<Object> enviarEmail(@RequestBody EmailFormulario formulario) {
        // Crie uma mensagem de email
        if(formulario.isEmpty()){
            return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body("Email com campos faltando.");
        }
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(formulario.getEmailRemetente());
        message.setTo("franciscocontatopro@gmail.com");
        message.setSubject("Novo email do formulário");
        message.setText(formulario.getConteudoEmail());

        // Envie o email
        emailSender.send(message);

        return ResponseEntity.status(HttpStatus.OK).body("Email enviado.");
    }

}

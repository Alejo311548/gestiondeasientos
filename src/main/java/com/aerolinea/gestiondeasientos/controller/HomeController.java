package com.aerolinea.gestiondeasientos.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public ResponseEntity<String> home() {
        return new ResponseEntity<>("Bienvenido a la API de gestión de asientos.", HttpStatus.OK);
    }
}

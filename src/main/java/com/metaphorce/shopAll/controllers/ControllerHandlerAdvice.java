package com.metaphorce.shopAll.controllers;

import com.metaphorce.shopAll.exceptions.PeliculaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@ControllerAdvice
public class ControllerHandlerAdvice {

    // Manejo de errores de validacion
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> validacionEntrada(MethodArgumentNotValidException ex){
        Map<String, String> errores = new HashMap<>(); // lista de errores vacia

        ex.getBindingResult().getFieldErrors().forEach(error -> { // Consigue todos y recoge cada error de validacion
            errores.put(error.getField(), error.getDefaultMessage()); // Guarda en el mapa el campo'nombre' y el mensaje de error
        });

        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }

    // Manejo de la excepcion personalizada (pelicula no encontrada)
    @ExceptionHandler(PeliculaNotFoundException.class)
    public ResponseEntity<String> validacionPelinoEncontrada(PeliculaNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Otras excepciones no controladas
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> validacionEntrada(Exception ex){
        return new ResponseEntity<>("Error interno del servidor: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

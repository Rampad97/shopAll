package com.metaphorce.shopAll.exceptions;

public class PeliculaNotFoundException extends RuntimeException{
    public PeliculaNotFoundException(String mensaje){
        super(mensaje);
    }
}

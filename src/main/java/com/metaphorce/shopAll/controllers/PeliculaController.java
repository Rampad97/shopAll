package com.metaphorce.shopAll.controllers;

import com.metaphorce.shopAll.entidades.Pelicula;
import com.metaphorce.shopAll.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopall")
public class PeliculaController {
    @Autowired
    PeliculaService peliculaService;

    @GetMapping("/peliculas")
    public ResponseEntity<List<Pelicula>> getPeliculas() {
        List<Pelicula> peliculas = peliculaService.getAllPeliculas();
        return ResponseEntity.ok(peliculas);
    }

    @GetMapping("/disponibles")
    public List<Pelicula> getDisponibles() {
        return peliculaService.getDisponibles();
    }

    @GetMapping("/no-disponibles")
    public List<Pelicula> getNoDisponibles() {
        return peliculaService.getNoDisponibles();
    }

    @PostMapping
    public Pelicula postPeli(@RequestBody Pelicula pelicula) {
        return peliculaService.agregarPelicula(pelicula);
    }

    @DeleteMapping("/{id}")
    public void deletePeli(@PathVariable Integer id) {
        peliculaService.deletePelicula(id);
    }

    @PutMapping("/{id}/disponible")
    public Pelicula putMarcarDisponible(@PathVariable Integer id) {
        return  peliculaService.marcaDisponible(id);
    }
}

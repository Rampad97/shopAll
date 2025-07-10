package com.metaphorce.shopAll.controllers;

import com.metaphorce.shopAll.entidades.Pelicula;
import com.metaphorce.shopAll.services.PeliculaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shopall")
public class PeliculaController {
    @Autowired
    PeliculaService peliculaService;

    @GetMapping("/peliculas")
    public ResponseEntity<?> getPeliculas() {
        List<Pelicula> peliculas = peliculaService.getAllPeliculas();

        if (peliculas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("No hay peliculas registradas");
        }
        return ResponseEntity.ok(peliculas);
    }

    @GetMapping("/disponibles")
    public ResponseEntity<?> getDisponibles() {
        List<Pelicula> disponibles = peliculaService.getDisponibles();

        if (disponibles.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("No hay peliculas disponibles");
        }
        return ResponseEntity.ok(disponibles);
    }

    @GetMapping("/no-disponibles")
    public ResponseEntity<?> getNoDisponibles() {
        List<Pelicula> noDisponibles = peliculaService.getNoDisponibles();

        if (noDisponibles.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("No hay peliculas no disponibles registrads.");
        }
        return ResponseEntity.ok(noDisponibles);
    }

    @PostMapping
    public ResponseEntity<String> postPeli(@Valid @RequestBody Pelicula pelicula) {
        Pelicula peli = peliculaService.addPelicula(pelicula);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Se agrego la pelicua \"" + pelicula.getNombre() + "\" correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePeli(@PathVariable Integer id) {
        peliculaService.deletePelicula(id);
        return ResponseEntity.ok("Se elimino la pelicua exitosamente");
    }

    @PutMapping("/{id}/disponible")
    public ResponseEntity<String> putMarcarDisponible(@PathVariable Integer id) {
        Pelicula actualizada = peliculaService.marcaDisponible(id);
        return ResponseEntity.ok("La pelicula \"" + actualizada.getNombre() + "\" ahora esta disponible");
    }
}

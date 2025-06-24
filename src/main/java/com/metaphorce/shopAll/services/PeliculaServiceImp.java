package com.metaphorce.shopAll.services;

import com.metaphorce.shopAll.entidades.Pelicula;
import com.metaphorce.shopAll.repositories.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImp implements PeliculaService{
    @Autowired
    PeliculaRepository peliculaRepository;

    @Override
    // Obtener todas las peliculas
    public List<Pelicula> getAllPeliculas() {
        return peliculaRepository.findAll();
    }

    // Obtener peliculas disponibles
    @Override
    public List<Pelicula> getDisponibles() {
        return peliculaRepository.findByDisponible(true);
    }

    // Obtener peliculas no disponibles
    @Override
    public List<Pelicula> getNoDisponibles() {
        return peliculaRepository.findByDisponible(false);
    }

    // Agregar pelicula
    public Pelicula agregarPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    // Eliminar pelicula
    @Override
    public void deletePelicula(Integer id) {
        peliculaRepository.deleteById(id);
    }

    // Marcar pelicula como diponible
    @Override
    public Pelicula marcaDisponible(Integer id) {
        // Optional puede contener el objeto o estar vacio
        Optional<Pelicula> peli = peliculaRepository.findById(id);
        if (peli.isPresent()) { // Verifica si el Optional contiene algo
            Pelicula p = peli.get(); // Obtiene el objeto Pelicula del Optional
            p.setDisponible(true); // Marca el estado como disponible
            return peliculaRepository.save(p); // Guarda cambios
        }
        return null; // Si no se encuentra la película devuelve null
    }
}

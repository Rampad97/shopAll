package com.metaphorce.shopAll.services;

import com.metaphorce.shopAll.entidades.Pelicula;

import java.util.List;

public interface PeliculaService {
    List<Pelicula> getAllPeliculas();
    List<Pelicula> getDisponibles();
    List<Pelicula> getNoDisponibles();
    Pelicula agregarPelicula(Pelicula pelicula);
    void deletePelicula(Integer id);
    Pelicula marcaDisponible(Integer id);

}

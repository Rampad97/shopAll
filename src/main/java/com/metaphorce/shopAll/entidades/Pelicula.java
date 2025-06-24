package com.metaphorce.shopAll.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "peliculas")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Clave primaria que se genera automaticamente
    private String nombre;
    private boolean disponible;

    // Constructores

    public Pelicula() {
    }

    public Pelicula(Integer id, String nombre, boolean disponible) {
        this.id = id;
        this.nombre = nombre;
        this.disponible = disponible;
    }

    // Getters y Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}

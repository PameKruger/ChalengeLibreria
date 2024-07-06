package com.pnegrete.ChallengeLibreria.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nombre;

    private int fechaDeNacimiento;

    private int fechaDeFallecimiento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros = new ArrayList<>();

    // Constructor sin parámetros
    public Autor() {
    }

    // Constructor con parámetros
    public Autor(DatosAutor datos) {
        this.nombre = datos.nombreDeAutor();
        this.fechaDeNacimiento = datos.anioDeNacimiento();
        this.fechaDeFallecimiento = datos.anioDeFallecimiento();
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(int fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public int getFechaDeFallecimiento() {
        return fechaDeFallecimiento;
    }

    public void setFechaDeFallecimiento(int fechaDeFallecimiento) {
        this.fechaDeFallecimiento = fechaDeFallecimiento;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        libros.forEach(l -> l.setAutor(this));
        this.libros = libros;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String blueColor = "\033[34m";
        String resetColor = "\033[0m";

        sb.append(blueColor)
                .append("====================================   A U T O R   ================================================================")
                .append(resetColor)
                .append("\nNombre: ").append(nombre)
                .append("\nFecha de Nacimiento: ").append(fechaDeNacimiento)
                .append("\nFecha de Fallecimiento: ").append(fechaDeFallecimiento)
                .append(blueColor)
                .append("\n===================================================================================================================")
                .append(resetColor);

        return sb.toString();
    }

}


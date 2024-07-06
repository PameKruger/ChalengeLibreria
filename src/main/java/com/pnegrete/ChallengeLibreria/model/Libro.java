package com.pnegrete.ChallengeLibreria.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nombre;
    private String idioma;
    private Integer cantidadDeDescargas;
    @ManyToOne
    private Autor autor;

    public Libro() {
        // Constructor por defecto
    }

    public Libro(DatosLibro datos){
        this.nombre = datos.nombreDeLibro();
        this.idioma = String.join(",",datos.idiomas());
        this.cantidadDeDescargas = datos.cantidadDeDescargas();
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdioma() {
        return idioma;
    }
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getCantidadDeDescargas() {
        return cantidadDeDescargas;
    }
    public void setCantidadDeDescargas(Integer cantidadDeDescargas) {
        this.cantidadDeDescargas = cantidadDeDescargas;
    }

    public Autor getAutor(){return autor;}
    public void setAutor(Autor autor){this.autor = autor;}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String redColor = "\033[31m";
        String resetColor = "\033[0m";

        sb.append("\n").append(redColor)
                .append("==========================   L I B R O    =========================================================================")
                .append(resetColor)
                .append("\nNombre: ").append(nombre)
                .append("\nIdioma: ").append(idioma)
                .append("\nAutor: ").append(autor.getNombre())
                .append("\nCantidad De Descargas: ").append(cantidadDeDescargas)
                .append(redColor)
                .append("\n===================================================================================================================")
                .append(resetColor);

        return sb.toString();
    }

}

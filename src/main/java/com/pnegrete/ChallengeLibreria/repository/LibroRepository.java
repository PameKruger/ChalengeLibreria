package com.pnegrete.ChallengeLibreria.repository;

import com.pnegrete.ChallengeLibreria.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro,Long> {

    boolean existsByNombre(String nombre);

    @Query("SELECT DISTINCT b.idioma FROM Libro b ORDER BY b.idioma")
    List<String> bucaridiomas();

    @Query("SELECT b FROM Libro b WHERE idioma = :idiomaSelecionado")
    List<Libro> buscarPorIdioma(String idiomaSelecionado);

    Libro findByNombre(String nombre);

    List<Libro> findTop10ByOrderByCantidadDeDescargas();

    @Query("SELECT b FROM Libro b WHERE b.autor.nombre ILIKE %:buscar%")
    List<Libro> encontrarLibrosPorAutor(String buscar);
}

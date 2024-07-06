package com.pnegrete.ChallengeLibreria.repository;

import com.pnegrete.ChallengeLibreria.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Boolean existsByNombre(String nombre);

    Autor findByNombre(String nombre);

    @Query("SELECT a FROM Autor a WHERE a.fechaDeFallecimiento >= :anoSelecionado AND :anoSelecionado >= a.fechaDeNacimiento")
    List<Autor> buscarPorfechaDeFallecimiento(int anoSelecionado);

    @Query("SELECT a FROM Autor a WHERE a.nombre ILIKE %:buscar%")
    List<Autor> encontrarPorNombre(String buscar);
}

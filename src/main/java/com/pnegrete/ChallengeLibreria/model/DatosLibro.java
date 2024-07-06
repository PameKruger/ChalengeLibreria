package com.pnegrete.ChallengeLibreria.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(@JsonAlias("title")String nombreDeLibro,
                         @JsonAlias("download_count") Integer cantidadDeDescargas,
                         @JsonAlias("languages") List<String> idiomas) {
}

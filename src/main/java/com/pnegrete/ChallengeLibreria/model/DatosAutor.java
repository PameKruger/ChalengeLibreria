package com.pnegrete.ChallengeLibreria.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(@JsonAlias("name")String nombreDeAutor,
                         @JsonAlias("birth_year") Integer anioDeNacimiento,
                         @JsonAlias("death_year") Integer anioDeFallecimiento) {
}

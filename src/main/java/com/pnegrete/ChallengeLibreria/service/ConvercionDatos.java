package com.pnegrete.ChallengeLibreria.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pnegrete.ChallengeLibreria.model.DatosAutor;
import com.pnegrete.ChallengeLibreria.model.DatosLibro;

public class ConvercionDatos implements IConvercionDatos{
    private ObjectMapper mapper = new ObjectMapper();


    @Override
    public <T> T getData(String json, Class<T> classe) {
        T resultado = null;
        try {
            if (classe == DatosLibro.class) {
                JsonNode node = mapper.readTree(json);
                var s = node.get("results").get(0);
                resultado = mapper.treeToValue(s, classe);
            }else if (classe == DatosAutor.class) {
                JsonNode node = mapper.readTree(json);
                var s = node.get("results").get(0).get("authors").get(0);
                resultado = mapper.treeToValue(s, classe);
            }else {
                resultado = mapper.readValue(json, classe);
            }
        }catch (JsonProcessingException e){
            e.getStackTrace();
            throw new RuntimeException(e);
        }
        return resultado;
    }
}

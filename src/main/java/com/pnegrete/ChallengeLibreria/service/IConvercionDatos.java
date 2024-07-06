package com.pnegrete.ChallengeLibreria.service;

public interface IConvercionDatos {
    <T> T getData(String json, Class<T> classe);
}

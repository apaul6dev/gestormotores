package com.grapes.mmotor.service;

import java.util.List;

public interface ICRUDTMP<T> {
    void registrar(T t);
    void modificar(T t);
    void eliminar(Long id);
    T listarId(Long id);
    List<T> listar();
}
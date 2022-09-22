package com.integrador.odonto.backendquintobimestre.service;

import java.util.List;

import com.integrador.odonto.backendquintobimestre.exception.NotFoundException;

public interface IClinicaService<T> {
    T create(T t) throws NotFoundException;
    T getById(int id) throws NotFoundException;
    List<T> getAll();
    String delete(int id);

    T update(T t, int id) throws NotFoundException;
}

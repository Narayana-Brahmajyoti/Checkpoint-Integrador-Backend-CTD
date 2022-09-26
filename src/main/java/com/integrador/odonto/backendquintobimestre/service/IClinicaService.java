package com.integrador.odonto.backendquintobimestre.service;

import java.util.List;

import com.integrador.odonto.backendquintobimestre.exception.NotFoundException;
import com.integrador.odonto.backendquintobimestre.exception.UniqueIndexException;

public interface IClinicaService<T> {
    T create(T t) throws NotFoundException, UniqueIndexException;
    T getById(int id) throws NotFoundException;
    List<T> getAll();
    String delete(int id) throws NotFoundException;

    T update(T t, int id) throws NotFoundException;
}

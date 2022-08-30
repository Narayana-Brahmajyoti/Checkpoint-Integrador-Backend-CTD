package com.integrador.odonto.backendquintobimestre.service;

public interface IClinicaService<T> {
    T create(T t);
    T getById(int id);
}

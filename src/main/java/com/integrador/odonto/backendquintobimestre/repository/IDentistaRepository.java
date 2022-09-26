package com.integrador.odonto.backendquintobimestre.repository;

import com.integrador.odonto.backendquintobimestre.entity.DentistaEntity;
import com.integrador.odonto.backendquintobimestre.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IDentistaRepository extends JpaRepository<DentistaEntity, Integer> {


    @Query("FROM DentistaEntity d WHERE d.matricula = :matricula")
    DentistaEntity findByMatricula(String matricula);


}

package com.integrador.odonto.backendquintobimestre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.integrador.odonto.backendquintobimestre.entity.PacienteEntity;

@Repository
public interface IPacienteRepository extends JpaRepository<PacienteEntity, Integer> {
    //HQL
    @Query("From PacienteEntity p Where p.nome = :nome")
    List<PacienteEntity> findByNome(String nome);
	
    //HQL
    @Query("From PacienteEntity p Where p.sobreNome = :sobrenome")
    List<PacienteEntity> findBySobrenome(String sobrenome);
	
    //HQL
    @Query("From PacienteEntity p Where p.rg = :rg")
    List<PacienteEntity> findByRg(String rg);
	
    //HQL
    @Query("From PacienteEntity p Where p.dataDeAlta = :dataDeAlta")
    List<PacienteEntity> findByDataDeAlta(String dataDeAlta);
}

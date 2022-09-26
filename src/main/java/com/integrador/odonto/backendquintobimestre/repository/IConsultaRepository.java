package com.integrador.odonto.backendquintobimestre.repository;

import com.integrador.odonto.backendquintobimestre.entity.ConsultaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IConsultaRepository extends JpaRepository<ConsultaEntity, Integer> {
    //Hibernate
//    @Query("FROM ConsultaEntity c Where c.nome = :nome")
    ConsultaEntity findByPaciente(String nome);
}

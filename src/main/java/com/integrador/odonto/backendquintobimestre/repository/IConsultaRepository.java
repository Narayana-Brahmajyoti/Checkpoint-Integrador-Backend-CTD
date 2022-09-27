package com.integrador.odonto.backendquintobimestre.repository;

import com.integrador.odonto.backendquintobimestre.entity.ConsultaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IConsultaRepository extends JpaRepository<ConsultaEntity, Integer> {
    //Hibernate
    @Query("From ConsultaEntity c Where c.paciente.nome = :nome")
    List<ConsultaEntity> findByPaciente(String nome);

    @Query("From ConsultaEntity c Where c.dataHoraConsulta = dataHoraConsulta")
    ConsultaEntity findByDataHoraConsulta(LocalDateTime dataHoraConsulta);
}

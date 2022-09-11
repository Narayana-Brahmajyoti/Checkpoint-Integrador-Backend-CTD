package com.integrador.odonto.backendquintobimestre.repository;

import com.integrador.odonto.backendquintobimestre.entity.PacienteEntity;
import com.integrador.odonto.backendquintobimestre.entity.dto.PacienteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<PacienteEntity, Integer> {

    //Hibernate
    PacienteEntity findById(int id);
    //PacienteEntity findAll();
    PacienteEntity delete(int id);
    PacienteEntity update(PacienteDTO pacienteDTO, int id);
    PacienteEntity findByName(String name);

    //HQL
    //@Query("From PacienteEntity p Where p.")
}

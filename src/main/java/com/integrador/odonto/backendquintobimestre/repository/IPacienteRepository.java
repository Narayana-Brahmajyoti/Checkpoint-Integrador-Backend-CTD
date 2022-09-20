package com.integrador.odonto.backendquintobimestre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.integrador.odonto.backendquintobimestre.entity.PacienteEntity;

@Repository
public interface IPacienteRepository extends JpaRepository<PacienteEntity, Integer> {

    //Hibernate
     PacienteEntity findByNome(String nome);

    //HQL
    //@Query("From PacienteEntity p Where p.")
	
}

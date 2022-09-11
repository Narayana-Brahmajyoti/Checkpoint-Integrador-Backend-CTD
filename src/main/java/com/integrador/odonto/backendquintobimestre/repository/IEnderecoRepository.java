package com.integrador.odonto.backendquintobimestre.repository;

import com.integrador.odonto.backendquintobimestre.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {


}

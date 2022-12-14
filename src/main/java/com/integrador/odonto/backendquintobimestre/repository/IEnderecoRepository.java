package com.integrador.odonto.backendquintobimestre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.integrador.odonto.backendquintobimestre.entity.EnderecoEntity;

@Repository
public interface IEnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {

}

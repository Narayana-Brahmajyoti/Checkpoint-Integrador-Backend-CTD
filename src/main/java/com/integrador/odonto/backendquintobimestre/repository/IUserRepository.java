package com.integrador.odonto.backendquintobimestre.repository;

import com.integrador.odonto.backendquintobimestre.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IUserRepository extends JpaRepository<UserEntity, Integer> {

}

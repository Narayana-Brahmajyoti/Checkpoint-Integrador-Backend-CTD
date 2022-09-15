package com.integrador.odonto.backendquintobimestre.repository;

import com.integrador.odonto.backendquintobimestre.entity.DentistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.Query;

public interface IDentistaRepository  extends JpaRepository<DentistaEntity, Integer> {


    DentistaEntity findByName(String nome);

    //HQL
    @Query("FROM DentistaEntity d where d.dentista = :name")
    DentistaEntity getByName(String nome);

    //SQL Native
    @Query(value = "SELECT * FROM Dentista d WHERE d.nome = :nome", nativeQuery = true)
    DentistaEntity getByNameSQL(String nome);

=======
import org.springframework.stereotype.Repository;

@Repository
public interface IDentistaRepository extends JpaRepository<DentistaEntity, Integer> {
    
>>>>>>> origin/Narayana_Brahmajyoti
}

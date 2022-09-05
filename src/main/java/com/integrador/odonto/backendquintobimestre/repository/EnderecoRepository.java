package com.integrador.odonto.backendquintobimestre.repository;

import com.integrador.odonto.backendquintobimestre.entity.EnderecoEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EnderecoRepository {
    private static Map<Integer, EnderecoEntity> enderecoMap = new HashMap<>();

    private static int idEndereco = 1;

    public EnderecoEntity create(EnderecoEntity enderecoEntity) {
        enderecoEntity.setId(idEndereco++);
        enderecoMap.put(enderecoEntity.getId(), enderecoEntity);
        return enderecoEntity;
    }

    public EnderecoEntity getById(int id) {
        return enderecoMap.get(id);
    }
}
